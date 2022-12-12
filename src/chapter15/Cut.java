package chapter15;

public class Cut {

    public static void main(String[] args) {
        int[] p = {0,1,5,8,9,10,17,17,20,24,30};
        int[] maxPrices = new int[11];
        int[] cutPositions = new int[11];
        int n = 9;
        cutRod(p, maxPrices, cutPositions, n);
        System.out.println("max price is " + maxPrices[n]);
        System.out.println("solution: ");
        printCut(cutPositions, n);
    }

    public static void cutRod(int[] p, int[] maxPrices, int[] cutPositions, int n) {
        for (int i = 0; i <= n; i++) {
            int maxPrice = Integer.MIN_VALUE;
            int cutPos = Integer.MIN_VALUE;
            for (int j = i; j >= 0; j--) {
                int price = p[j] + maxPrices[i - j];
                if (price > maxPrice) {
                    maxPrice = price;
                    cutPos = j;
                }
            }
            maxPrices[i] = maxPrice;
            cutPositions[i] = cutPos;
        }
    }

    public static void printCut(int[] cutPositions, int n) {
        if (n > 0) {
            System.out.println(cutPositions[n]);
            printCut(cutPositions, n - cutPositions[n]);
        }
    }
}
