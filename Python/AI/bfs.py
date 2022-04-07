# -*- coding:utf-8 -*-

class Maze:
    def __init__(self, map, n, m, x, y):
        self.ans = 0            #最短步长结果
        self.map = map          #迷宫地图map[0,n-1][0,m-1]（下标0开始）
        self.n = n              #迷宫地图行数n
        self.m = m              #迷宫地图列数m
        self.x = x              #起点，行坐标（下标0开始）
        self.y = y              #起点，列坐标（下标0开始）

class Solution:

    def solveMaze(self, maze):
        """求解迷宫问题
        :type: maze: class Maze #迷宫的数据结构类
        :rtype: maze.ans: int   #返回最短路径长度
        """

        #请在这里补充代码，完成本关任务
        #********** Begin **********#
        queue = [maze.x*maze.m + maze.y]

        visit = [[0 for col in range(maze.m)] for row in range(maze.n)]
        visit[maze.x][maze.y] = 1
        maze.ans = 10000

        maze.ans = self.bfs(queue, visit, maze)
        return maze.ans
        #********** End **********#

    def bfs(self, queue, visit, maze):
        """深搜

        """
        optional_x = [-1,1,0,0]     #上下左右
        optional_y = [0,0,-1,1]
        # 题目保证有解
        while len(queue) > 0 :
            resolve_value = queue[0]
            queue = queue[1:]       # 将第一个元素删除，简陋的模拟队列效果
            cur_y = resolve_value % maze.m
            cur_x = (int)((resolve_value - cur_y) / maze.n)
            
            if cur_x == 0 or cur_x == maze.n-1 or cur_y == 0 or cur_y == maze.m-1 :
                return visit[cur_x][cur_y] - 1

            for i in range(4):
                trans_x = cur_x + optional_x[i]
                trans_y = cur_y + optional_y[i]

                if trans_x >= 0 and trans_x < maze.n and trans_y >=0 and trans_y < maze.m and \
                    maze.map[trans_x][trans_y] != 0 and visit[trans_x][trans_y] == 0 :
                    queue.append(trans_x*maze.m + trans_y)
                    visit[trans_x][trans_y] = visit[cur_x][cur_y] + 1
        return 0

    
if __name__ == '__main__':
    map = [
        [0,1,0,0,0,0,1],
        [0,1,1,1,0,0,1],
        [0,1,0,0,0,0,1],
        [0,1,1,1,1,0,1],
        [0,1,0,0,1,0,1],
        [0,1,0,0,0,0,1]
    ]
    maze = Maze(map, 6, 7, 3, 2)

    solution = Solution()
    print(solution.solveMaze(maze))    