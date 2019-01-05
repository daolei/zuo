package champter4;

/**
 * Created by daolei.su on 2019/1/3
 * 字符串a 转 字符串b 获取最小的变换效果
 */
public class MinCosts {
    public static void main(String[] args) {
        String from = "ab12cd3";
        String to = "abcdf";

        int ic = 5, dc = 3, rc = 2;

        System.out.println(getMinCosts(from, to, ic, dc, rc));
    }

    /**
     *
     * @param from
     * @param to
     * @param ic 添加一个字符的权重
     * @param dc 删除一个字符的权重
     * @param rc 修改一个字符的权重
     * @return 最少消耗
     */

    public static int getMinCosts(String from, String to, int ic, int dc, int rc) {
        char[] c1 = from.toCharArray();
        char[] c2 = to.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        //初始化from 首先变成空字符串'',有几个就是删除几个 [0..i] * dc
        for (int i = 0; i < c1.length; i++) {
            dp[i][0] = dc * i;
        }

        //初始化，当from为空字符串时'' 要变为[0...j]个to字符串时，所需要的就是
        for (int i = 0; i < c2.length; i++) {
            dp[0][i] = ic * i;
        }
        //剩余就开始创建dp矩阵！！！
        for (int i = 1; i < c1.length + 1; i++) {
            for (int j = 1; j < c2.length + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic);
                if (c1[i - 1] != c2[j - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc, dp[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
        return dp[c1.length][c2.length];
    }
}
