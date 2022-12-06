package Chapter15;

public class MatrixChainOrder {

    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] optCost = new int[6][6];
        int[][] optPosition = new int[6][6];
        optimizedChainOrder(p, optCost, optPosition);
        System.out.println("optimized cost is: " + optCost[0][5]);
        System.out.println("solution is: ");
        printSolution(optPosition, 0, 5);
    }

    private static void optimizedChainOrder(int[] p, int[][] optCost, int[][] optPosition) {
        int n = p.length - 1;
        for (int i = 0; i < n; i++) {
            optCost[i][i] = 0;
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int minCost = Integer.MAX_VALUE;
                int minPos = Integer.MAX_VALUE;
                int start = i;
                int end = i + length - 1;
                for (int j = i; j < end; j++) {
                    // (start to end) is cut by j
                    // NOTE: cost of two matrix is p[start] * p[j + 1] * p[end + 1]!
                    int cost = optCost[start][j] + optCost[j + 1][end] + p[start] * p[j + 1] * p[end + 1];
                    if (cost < minCost) {
                        minCost = cost;
                        minPos = j;
                    }
                }
                optCost[start][end] = minCost;
                optPosition[start][end] = minPos;
            }
        }
    }

    private static void printSolution(int[][] optPosition, int start, int end) {
        //NOTE recursive print
        if (start == end) {
            System.out.print("A" + start);
        } else {
            System.out.print("(");
            printSolution(optPosition, start, optPosition[start][end]);
            printSolution(optPosition, optPosition[start][end] + 1, end);
            System.out.print(")");
        }
    }
}
