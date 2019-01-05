package champter4;

/**
 * Created by daolei.su on 2019/1/1
 * 改过程使用二维数组来记录经验，其中dp[i][j]为使用i种货币，能得到货币值为j的最小张数
 * dp[i][j] = min{dp[i-1][j], dp[i][j-arr[i]] + 1}
 * 初始化第一列值相当于全部j为0时需要的货币张数全都为0, 初始化第一行
 * 时间复杂度为 O(M*N) 空间复杂度为 O(M*N)
 */
public class CoinsNum {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 25, 1};
        int aim = 15;
        System.out.println(getMinCoinesNum(arr, aim));
    }

    private static int getMinCoinesNum(int[] arr, int aim) {
        int[][] dp = new int[arr.length][aim + 1];
        //第一列默认为全部j为0时的货币张数，默认为0，所以就可以在第二列开始遍历。
        //初始化，第一行,即只使用1种货币可以得到的j的张数。
        for (int i = 1; i <= aim; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = j - arr[i] < 0 ?
                        Math.min(dp[i - 1][j], Integer.MAX_VALUE) :
                        Math.min(dp[i - 1][j],
                                dp[i][j - arr[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j - arr[i]] + 1);
            }
        }


        return dp[arr.length - 1][aim] == Integer.MAX_VALUE ? -1 : dp[arr.length - 1][aim];

    }
}
