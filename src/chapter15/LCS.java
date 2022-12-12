package chapter15;

/**
 * Created by john.xu at 2022-12-07 21:37
 */
public class LCS {

    public static void main(String[] args) {
        char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
        // res[i][j] means whether Xi == Yj and be the end of LCS of Xi and Yj
        // Note prepare for zero-length String
        int[][] length = new int[X.length + 1][Y.length + 1];
        int[][] res = new int[X.length + 1][Y.length + 1];
        lcsLength(X, Y, length, res);
        System.out.println("LCS length is: " + length[X.length][Y.length]);
        System.out.println("LCS is: ");
        printLCS(X, Y, res, X.length, Y.length, new StringBuilder());
    }

    private static void lcsLength(char[] X, char[] Y, int[][] length, int[][] res) {
        for (int i = 0; i <= X.length; i++) {
            length[i][0] = 0;
        }
        for (int j = 0; j <= Y.length; j++) {
            length[0][j] = 0;
        }
        for (int j = 1; j <= Y.length; j++) {
            for (int i = 1; i <= X.length; i++) {
                if (X[i - 1] == Y[j - 1]) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                    // LCS(X[i], Y[j]) = LCS(X[i-1], Y[j-1]) + X[i]
                    res[i][j] = 100;
                } else if (length[i - 1][j] > length[i][j - 1]) {
                    length[i][j] = length[i - 1][j];
                    res[i][j] = -1;
                } else if (length[i - 1][j] < length[i][j - 1]) {
                    length[i][j] = length[i][j - 1];
                    res[i][j] = 1;
                } else {
                    length[i][j] = length[i - 1][j];
                    res[i][j] = 233;
                }
            }
        }
    }

    private static void printLCS(char[] X, char[] Y, int[][] res, int xPosition, int yPosition, StringBuilder sb) {
        if (xPosition > 0 && yPosition > 0) {
            if (res[xPosition][yPosition] == 100) {
                sb.append(X[xPosition - 1]);
                //Note after print, we still need to print!
                printLCS(X, Y, res, xPosition - 1, yPosition - 1, sb);
            } else if (res[xPosition][yPosition] == 1) {
                printLCS(X, Y, res, xPosition, yPosition - 1, sb);
            } else if (res[xPosition][yPosition] == -1) {
                printLCS(X, Y, res, xPosition - 1, yPosition, sb);
            } else {
                //both side of substring can be LCS
                printLCS(X, Y, res, xPosition, yPosition - 1, new StringBuilder(sb));
                printLCS(X, Y, res, xPosition - 1, yPosition, new StringBuilder(sb));
            }
        } else {
            System.out.println(sb.reverse().toString());
        }
    }

}
