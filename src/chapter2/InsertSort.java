package chapter2;

import util.Util;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5,7,6,8,9,10};
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("final result: " + Util.array2Str(arr, 0, arr.length - 1));
    }
}