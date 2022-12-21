package chapter16;

/**
 * Created by john.xu at 2022-12-21 11:51
 */
public class Knapsack01 {

    // ith item put in package of weight j
    // maxVal[i][j]
    // maxVal[i][j] = max(maxVal[i - 1][j], maxVal[i - 1][j - weight[i]] + val[i])
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int totalW = 50;
        int[][] maxVal = new int[val.length][totalW + 1];
        // boolean array indicated put or not put
        boolean[][] result = new boolean[val.length][totalW + 1];
        package01(val, weight, totalW, maxVal, result);
        System.out.println("max value is : " + maxVal[val.length - 1][totalW]);
        printResult(result, 2, 50, weight);
    }

    private static void printResult(boolean[][] result, int i, int j, int[] weight) {
        while (i >= 0 && j > 0) {
            if (result[i][j]) {
                System.out.println(i + "th item");
                j = j - weight[i];
                i--;
            } else {
                i--;
            }
        }
    }

    private static void package01(int[] val, int[] weight, int totalW, int[][] maxVal, boolean[][] result) {
        for (int i = 0; i < val.length; i++) {
            // none of the item can be put into package of weight 0
            maxVal[i][0] = 0;
        }
        for (int j = 0; j < weight[0]; j++) {
            // cannot put i0
            maxVal[0][j] = 0;
        }
        for (int j = weight[0]; j <= totalW; j++) {
            // can put i0
            maxVal[0][j] = val[0];
            result[0][j] = true;
        }
        for (int i = 1; i < val.length; i++) {
            for (int j = 1; j <= totalW; j++) {
                if (weight[i] > j) {
                    //cannot put i, only one choice: see i - 1
                    maxVal[i][j] = maxVal[i - 1][j];
                } else {
                    // can put i, mac of two choice
                    int dontPut = maxVal[i - 1][j];
                    int put = maxVal[i - 1][j - weight[i]] + val[i];
                    if (put > dontPut) {
                        maxVal[i][j] = put;
                        result[i][j] = true;
                    } else {
                        maxVal[i][j] = dontPut;
                    }
                }
            }
        }
    }

}
