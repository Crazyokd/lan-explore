#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct Card {
    int v;
#define HOR 0x100
#define VER 0x10
#define ELE 0x1
    int f;
} Card;

#ifndef MAX_VALUE
  #define MAX_VALUE 12
#endif

Card getCard(int, int)
{
    Card card;
    card.v = rand() % MAX_VALUE;
    card.f = 0;
    return card;
}

#ifndef NROW
  #define NROW 5
#endif
#ifndef NCOL
  #define NCOL 6
#endif
static Card arr[NROW][NCOL];
/*
= {
        {{1, 0}, {2, 0}, {0, 0}, {2, 0}, {1, 0}, {1, 0}},
        {{1, 0}, {2, 0}, {1, 0}, {0, 0}, {2, 0}, {0, 0}},
        {{0, 0}, {0, 0}, {1, 0}, {2, 0}, {0, 0}, {0, 0}},
        {{0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {2, 0}},
        {{1, 0}, {2, 0}, {1, 0}, {1, 0}, {2, 0}, {1, 0}}
};
*/

void init()
{
    srand((unsigned)time(NULL));
    for (int i = 0; i < NROW; ++i) {
        for (int j = 0; j < NCOL; ++j) {
            arr[i][j] = getCard(i, j);
        }
    }
}

static void display()
{
    for (int i = 0; i < NCOL*3; i++) {
        printf("=");
    }
    printf("\n");
    for (int i = 0; i < NROW; ++i) {
        for (int j = 0; j < NCOL; ++j) {
            printf("%2d", arr[i][j].v);
            if (j < NCOL - 1) {
                printf(" ");
            }
        }
        printf("\n");
    }
}

#ifndef MIN_ELE
  #define MIN_ELE 5
#endif
static inline void hormatch(int row, int col)
{
    if (NCOL - col < MIN_ELE) {
        return;
    }
    if ((col + 1 < NCOL && (arr[row][col + 1].f & HOR) == HOR)
        || (arr[row][col].v != 0 && (arr[row][col].f & HOR) == HOR)) {
        // 已经比较过
        return;
    }
    int i = col + 1;
    int n = 1;
    int v = arr[row][col].v;
    while (i < NCOL) {
        if (v == 0) v = arr[row][i].v;

        if (arr[row][i].v == 0 || v == arr[row][i].v) {
            arr[row][col].f |= HOR;
            n++;
        } else if (n < MIN_ELE) {
            return;
        } else {
            break;
        }
        i++;
    }
    // 标记为消除
    for (int k = 0; k < n; k++) {
        arr[row][col++].f |= ELE;
    }
}

static inline void vermatch(int row, int col)
{
    if (NROW - row < MIN_ELE) {
        return;
    }
    if ((row + 1 < NROW && (arr[row + 1][col].f & VER) == VER)
        || (arr[row][col].v != 0 && (arr[row][col].f & VER) == VER)) {
        // 已经比较过
        return;
    }
    int i = row + 1;
    int n = 1;
    int v = arr[row][col].v;
    while (i < NROW) {
        if (v == 0) v = arr[i][col].v;

        if (arr[i][col].v == 0 || v == arr[i][col].v) {
            arr[row][col].f |= VER;
            n++;
        } else if (n < MIN_ELE) {
            return;
        } else {
            break;
        }
        i++;
    }
    // 标记为消除
    for (int k = 0; k < n; k++) {
        arr[row++][col].f |= ELE;
    }
}
/**
 * 标记所有待消除的牌
 */
static void mark()
{
    for (int i = 0; i < NROW; i++) {
        for (int j = 0; j < NCOL; j++) {
            hormatch(i, j); // 横向比较
            vermatch(i, j); // 纵向比较
        }
    }
}

static inline int isStill(int row, int col)
{
    return (arr[row][col].f & ELE) == 0;
}

static int nele = 0;
static inline Card getNext(int *vi, int row, int col)
{
    while (*vi >= 0) {
        *vi = *vi - 1;
        if (isStill(*vi + 1, col)) {
            arr[*vi + 1][col].f = 0; // 还原标志位
            return arr[*vi + 1][col];
        }
    }
    ++nele;
    return getCard(row, col);
}

static int eliminate()
{
    nele = 0; // 置0
    // 遍历每一列
    for (int i = 0; i < NCOL; ++i) {
        int vi = NROW - 1; // valid index
        // 掉落
        for (int j = vi; j >= 0; --j) {
            arr[j][i] = getNext(&vi, j, i);
        }
    }
    return nele;
}

/**
 * 输出结果
 */
static void over()
{
    printf("\n!!!game over!!!\n");
}

/**
 * Usage: gcc main.c -o game -DMAX_VALUE=3 -DNROW=10 -DNCOL=16 -DMIN_ELE=5 && ./game
 */
int main()
{
    init();

    do {
        display();
        mark();
        sleep(1);
    } while (eliminate() != 0);

    over();
    return 0;
}
