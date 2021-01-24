/*给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步

解题方法：动态规划，每个格子的最小值等于左格子和上格子的最小值加上本身。
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(i==0&&j>0){
                    grid[i][j]=grid[i][j]+grid[i][j-1];
                }
                if(i>0&&j==0) {
                    grid[i][j]=grid[i][j]+grid[i-1][j];
                }
                if(i!=0&&j!=0){
                    grid[i][j]=Math.min(grid[i][j]+grid[i][j-1],grid[i][j]+grid[i-1][j]);
                }
            }
        }
        return grid[y-1][x-1];
    }
}