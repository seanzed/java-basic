package com.sean.study.solution.datastructure.queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 * @Description: 实现广度搜索BFS
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-25 17:07
 * @Version: 1.0
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        // 行数
        int row = grid.length;
        // 列数
        int column = grid[0].length;

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    combine(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void combine(char[][] grid, int x, int y) {
        grid[x][y] = '2';
        if (x > grid.length - 1 && y > grid[0].length) {
            return;
        }

        // 向上
        if (x > 0 && grid[x-1][y] == '1') {
            combine(grid, x - 1, y);
        }
        // 向下
        if (y > 0 && grid[x][y-1] == '1') {
            combine(grid, x , y -1 );
        }

        // 向下
        if (x < grid.length - 1 && grid[x+1][y] == '1') {
            combine(grid, x + 1, y);
        }

        // 向右
        if (y < grid[0].length -1 && grid[x][y+1] == '1') {
            combine(grid, x, y + 1);
        }
    }
}
