#include <forward_list>
#include <string>
#include <stack>
#include <iostream>

using std::forward_list;
using std::string;
using std::stack;


void print()
{
    std::cout << "empty" << std::endl;
}

template<typename T, typename... Types>
void print (T firstArg, Types... args)
{
    std::cout << firstArg << std::endl;
    if (sizeof...(args) > 0) {
        print(args...);
    }
}

template<typename T, typename... Types>
void print(Types... args)
{
    if (sizeof...(args) > 0) {
        print(args...);
    }
}

struct Node{
int value;
Node*left;
Node*right;
Node(int i=0):value(i),left(nullptr),right(nullptr){
}
};

 auto left = &Node::left;
 auto right=&Node::right;

 // traverse tree, using fold expression:
 template<typename T, typename...TP>
 Node*traverse(T np, TP...paths) {
 return (np->* ...->* paths); // np->* paths1->* paths2 ...
 }

 int main()
 {
 // init binary tree structure:
 Node*root= new Node{0};
 root->left= new Node{1};
 root->left->right= new Node{2};
 // traverse binary tree:
 Node*node=traverse(root,left, right);
 }

void testStack()
{
    stack<int> initStack;

    for (size_t ix = 0; ix != 10; ++ix) {
        initStack.push(ix);
    }
    while (!initStack.empty()) {
        int v = initStack.top();
        initStack.pop();
    }
}
int main()
{
	forward_list<int> fl;
	fl.assign(3, 3);
	fl.insert_after(fl.begin(), 4);
    fl.erase_after(fl.begin());

    fl.resize(10, -1);

    print(12);
}
