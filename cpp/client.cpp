#include <iostream>
#include <arpa/inet.h>
#include <unistd.h>
#include <thread>
#include <cstring>
#include <cmath>
#include <getopt.h>

void handle_client(int client_fd)
{
    char buffer[1024];
    while (true) {
        memset(buffer, 0, sizeof(buffer));
        int bytes_received = recv(client_fd, buffer, sizeof(buffer), 0);
        if (bytes_received <= 0) {
            std::cerr << "Connection closed or error occurred" << std::endl;
            break;
        }
        std::cout << "Recevied: " << buffer << std::endl;
    }
    close(client_fd);
}
#define MAX_BACK_LOG_CNT 3
void listen_on_port(const char *ip, int port) {
    int server_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (server_fd == -1) {
        std::cerr << "Failed to create socket" << std::endl;
        return;
    }

    struct sockaddr_in address;
    address.sin_family = AF_INET;
    address.sin_port = htons(port);

    if (inet_pton(AF_INET, ip, &address.sin_addr) <= 0) {
        std::cerr << "Invalid address or Address not supported" << std::endl;
        close(server_fd);
        return;
    }

    if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {
        std::cerr << "Bind failed" << std::endl;
        close(server_fd);
        return;
    }

    if (listen(server_fd, MAX_BACK_LOG_CNT) < 0) {
        std::cerr << "Listen failed" << std::endl;
        close(server_fd);
        return;
    }

    std::cout << "Listening on port " << port << std::endl;

    while (true) {
        struct sockaddr_in client_addr;
        socklen_t addr_size = sizeof(client_addr);
        /* todo: constraint active connection count */
        int client_fd = accept(server_fd, (struct sockaddr *)&client_addr, &addr_size);
        if (client_fd < 0) {
            std::cerr << "Accept failed" << std::endl;
            continue;
        }

        std::cout << "Connection accepted" << std::endl;
        // handle_client(client_fd);
        std::thread client_thread(handle_client, client_fd);
        client_thread.detach();
    }

    close(server_fd);
}

int connect_to_port(const char* ip, int port) {
    int client_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (client_fd == -1) {
        std::cerr << "Failed to create socket" << std::endl;
        return -1;
    }

    struct sockaddr_in address;
    address.sin_family = AF_INET;
    address.sin_port = htons(port);

    if (inet_pton(AF_INET, ip, &address.sin_addr) <= 0) {
        std::cerr << "Invalid address/ Address not supported" << std::endl;
        close(client_fd);
        return -1;
    }

    if (connect(client_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {
        std::cerr << "Connection failed" << std::endl;
        close(client_fd);
        return -1;
    }

    std::cout << "Connected to " << ip << " on port " << port << std::endl;

    // 进入循环，持续接收并打印数据
    char buffer[1024];
    while (true) {
        memset(buffer, 0, sizeof(buffer));
        int bytes_received = recv(client_fd, buffer, sizeof(buffer), 0);
        if (bytes_received <= 0) {
            std::cerr << "Connection closed or error occurred" << std::endl;
            break;
        }
        std::cout << "Received: " << buffer << std::endl;
    } 
    close(client_fd);
    return 0;
}

void connect_thread(const char *ip, int port)
{
    int init_retry_delay, retry_delay;
    const int max_retry_delay = 60000;
    retry_delay = init_retry_delay = 1000;

    while (true) {
        if (connect_to_port(ip, port) == 0) {
            retry_delay = init_retry_delay;
        } else {
            retry_delay = std::min(max_retry_delay, retry_delay * 2);
        }
        std::this_thread::sleep_for(std::chrono::milliseconds(retry_delay));
    }
}

/* Usage: ./client --listen_port 6340 --connect_port 6330 */
int main(int argc, char *argv[]) {
    int listen_port = 6340, connect_port = 6330;

    const struct option long_options[] = {
        {"listen_port", required_argument, nullptr, 'l'},
        {"connect_port", required_argument, nullptr, 'c'},
        {nullptr, 0, nullptr, 0},
    };

    int opt;
    while ((opt = getopt_long(argc, argv, "lc", long_options, nullptr)) != EOF) {
        if (opt == -1) break;
        if (!optarg) continue;
        switch (opt) {
            case 'l':
                listen_port = std::stoi(optarg);
                break;
            case 'c':
                connect_port = std::stoi(optarg);
                break;
            default:
                std::cerr << "Usage: " << argv[0] << " --listen_port <port> --connect_port <port>"
                          << std::endl;
                return 1;
        }
    }

    if (listen_port == 0 || connect_port == 0) {
        std::cerr << "Usage: " << argv[0] << " --listen_port <port> --connect_port <port>" << std::endl;
        return 1;
    }

    std::thread listener(listen_on_port, "127.0.0.1", listen_port);
    listener.detach();

    std::thread connector(connect_thread, "127.0.0.1", connect_port);
    connector.detach();

    // Keep the main thread alive
    while (true) {
        sleep(1);
    }

    return 0;
}
