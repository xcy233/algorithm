package chapter2;

import util.Util;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5,7,6,8,9,10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("final result: " + Util.array2Str(arr, 0, arr.length - 1));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle + 1, end);
        }
    }

    public static void merge(int[] arr, int start, int middle, int end) {
        System.out.println("merge array " + Util.array2Str(arr, start, middle - 1) + " and " + Util.array2Str(arr, middle, end));
        int leftLength = middle - start;
        int rightLength = end - middle + 1;
        int[] leftArr = new int[leftLength + 1];
        int[] rightArr = new int[rightLength + 1];
        for (int i = 0; i < leftLength; i++) {
            leftArr[i] = arr[start + i];
        }
        leftArr[leftLength] = Integer.MAX_VALUE;
        for (int i = 0; i < rightLength; i++) {
            rightArr[i] = arr[middle + i];
        }
        rightArr[rightLength] = Integer.MAX_VALUE;
        int leftPos = 0;
        int rightPos = 0;
        for (int i = start; i <= end; i++) {
            if (leftArr[leftPos] > rightArr[rightPos]) {
                arr[i] = rightArr[rightPos];
                rightPos++;
            } else {
                arr[i] = leftArr[leftPos];
                leftPos++;
            }
        }
        System.out.println("result is: " + Util.array2Str(arr, start, end));
    }
}
