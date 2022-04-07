# -*- coding:utf-8 -*-

class Solution:

    def __init__(self, n=0):
        self.ans = 0                #用于存储答案（N皇后方案数，初始值0）
        self.n = n                  #用于存储皇后数量n
        self.vis = [[0 for col in range(n)] for row in range(n)]             #用于标记是否存在皇后的二维列表（初始值全为0）


    def solveNQueens(self):
        """求解N皇后问题（调用self.DFS函数）
        :rtype: self.ans: int    #返回N皇后放置方案数
        """

        #请在这里补充代码，完成本关任务
        #********** Begin **********#
        self.DFS(0, 0)
        return self.ans
        #********** End **********#


    def DFS(self, row, n):
        """深度优先搜索N皇后问题的解空间
        :type: row: int      #NxN棋盘的第row行
        :type: n: int        #皇后数量n
        :rtype: None         #无返回值
        """
        
        #请在这里补充代码，完成本关任务
        #********** Begin **********#
        if n == self.n : 
            self.ans += 1
            return 

        for i in range(self.n):
            if self.check(row, i):
                self.vis[row][i] = 1
                self.DFS(row+1, n+1)
                self.vis[row][i] = 0

        #********** End **********#

    def check(self, row, col):
        for i in range(row) :
            if self.vis[row-1-i][col] != 0 or (col-i-1 >= 0 and self.vis[row-1-i][col-i-1] != 0) or \
                (col+i+1 < self.n and self.vis[row-1-i][col+i+1] != 0) :
                return False
        return True


if __name__ == '__main__' :
    solution = Solution(5)
    print(solution.solveNQueens())