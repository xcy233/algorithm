package chapter4;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] price = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int[] priceDelta = new int[price.length - 1];
        for (int i = 1; i < price.length; i++) {
            priceDelta[i - 1] = price[i] - price[i - 1];
        }
        Interval interval = maxSubArray(priceDelta, 0, priceDelta.length - 1);
        System.out.println("buy at " + interval.left + " day, and sell at " + (interval.right + 1) + " day");
    }

    public static Interval maxSubArray(int[] delta, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            Interval leftMaxInterval = maxSubArray(delta, left, middle);
            Interval rightMaxInterval = maxSubArray(delta, middle + 1, right);
            Interval crossMaxInterval = crossMaxSubArray(delta, left, middle, right);
            if (leftMaxInterval.sum >= rightMaxInterval.sum && leftMaxInterval.sum >= crossMaxInterval.sum) {
                return leftMaxInterval;
            } else if (rightMaxInterval.sum >= leftMaxInterval.sum && rightMaxInterval.sum >= crossMaxInterval.sum) {
                return rightMaxInterval;
            } else {
                return crossMaxInterval;
            }
        } else {
            return new Interval(left, right, delta[left]);
        }
    }

    public static Interval crossMaxSubArray(int[] delta, int left, int middle, int right) {
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        int leftMaxPosition = middle;
        for (int i = middle; i >= left; i--) {
            leftSum += delta[i];
            if (leftSum > leftMax) {
                leftMax = leftSum;
                leftMaxPosition = i;
            }
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        int rightMaxPosition = middle;
        for (int i = middle + 1; i <= right; i++) {
            rightSum += delta[i];
            if (rightSum > rightMax) {
                rightMax = rightSum;
                rightMaxPosition = i;
            }
        }
        return new Interval(leftMaxPosition, rightMaxPosition, leftMax + rightMax);
    }

    public static class Interval {
        public int left;
        public int right;
        public int sum;
        public Interval(int l, int r, int s) {
            left = l;
            right = r;
            sum = s;
        }
    }
}