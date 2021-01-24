/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
如果该位置的值是 00，则 dp(i, j) = 0dp(i,j)=0，因为当前位置不可能在由 11 组成的正方形中；

如果该位置的值是 11，则 dp(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dpdp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 11，状态转移方程如下：
dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
*/
// 终版代码
public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

    int height = matrix.length;
    int width = matrix[0].length;
    int maxSide = 0;

    int[] dp = new int[width + 1];

    for (char[] chars : matrix) {
        int northwest = 0; // 个人建议放在这里声明，而非循环体外
        for (int col = 0; col < width; col++) {
            int nextNorthwest = dp[col + 1];
            if (chars[col] == '1') {
                dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;
                maxSide = Math.max(maxSide, dp[col + 1]);
            } else dp[col + 1] = 0;
            northwest = nextNorthwest;
        }
    }
    return maxSide * maxSide;
}