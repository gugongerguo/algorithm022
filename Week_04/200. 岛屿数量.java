/**
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
 */
class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                //遍历每个元素，如果是陆地就进入递归
                if(grid[i][j]=='1'){
                    process(i,j,grid);
                    island++;
                }
            }
        }
        return island;
    }

    private void process(int i,int j,char[][] grid) {
        //下标越界或者当前是水直接返回
        if(i<0||j<0||i>grid.length-1||j>grid[i].length-1||grid[i][j]=='0') return;
        //当前陆地变成水
        grid[i][j]='0';
        //上下左右元素递归
        process(i-1,j,grid);
        process(i+1,j,grid);
        process(i,j-1,grid);
        process(i,j+1,grid);
    }
}