package champter4;

/**
 * Created by daolei.su on 2019/1/2
 * 根据动态规划建立一个记录矩阵,dp[i][j] 的意义是走到i,j时所用的最短路径，其等于 arr[i][j] + dp[i-1][j-1]
 */
public class ShortestPath {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(getMinPaths(arr));
    }

    public static int getMinPaths(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (j - 1 >= 0) {
                    dp[i][j] = arr[i][j] + dp[i][j - 1];
                } else if (i - 1 >= 0) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = arr[i][j];
                }
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }
}
