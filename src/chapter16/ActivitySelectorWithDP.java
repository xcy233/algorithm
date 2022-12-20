package chapter16;

public class ActivitySelectorWithDP {

    public static void main(String[] args) {
        int[] s = {1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {4,5,6,7,9,9,10,11,12,14,16};
        int[][] num = new int[11][11];
        int[][] res = new int[11][11];
        MaxEntity maxEntity = selector(s, f, num, res);
        System.out.println("largest num of activity is " + (maxEntity.maxNum + 2));
        System.out.println("most left activity is a" + maxEntity.s);
        System.out.println("most right activity is a" + maxEntity.f);
        System.out.println("others are: ");
        printResult(res, maxEntity);
    }

    private static void printResult(int[][] res, MaxEntity e) {
        int activity = res[e.s][e.f];
        if (activity > 0) {
            System.out.println("a" + activity);
            printResult(res, new MaxEntity(e.maxNum - 1, e.s, activity));
            printResult(res, new MaxEntity(e.maxNum - 1, activity, e.f));
        }
    }

    private static MaxEntity selector(int[] s, int[] f, int[][] num, int[][] res) {
        MaxEntity entity = new MaxEntity(0, 0, 0);
        for (int l = 2; l <= s.length; l++) {
            for (int i = 0; i <= s.length - l; i++) {
                int left = i;
                int right = i + l - 1;
                int maxNum = 0;
                int maxPos = 0;
                for (int j = 0; j < s.length; j++) {
                    if (f[left] <= s[j] && f[j] < s[right]) {
                        int currentNum = num[left][j] + num[j][right] + 1;
                        if (currentNum > maxNum) {
                            maxNum = currentNum;
                            maxPos = j;
                        }
                    }
                }
                num[left][right] = maxNum;
                res[left][right] = maxPos;
                if (maxNum > entity.maxNum) {
                    entity.maxNum = maxNum;
                    entity.s = left;
                    entity.f = right;
                }
            }
        }
        return entity;
    }

    private static class MaxEntity {
        public int maxNum;

        public int s;

        public int f;

        public MaxEntity(int num, int s, int j) {
            maxNum = num;
            this.s = s;
            this.f = j;
        }
    }

}
