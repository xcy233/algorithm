package chapter7;

import util.Util;

/**
 * Created by john.xu at 2022-12-12 22:50
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {1,3,2,4,5,7,6,8,10,13,15,12};
        quickSort(a, 0, a.length - 1);
        System.out.println(Util.array2Str(a, 0, a.length - 1));
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int pivot = l;
            for (int i = l + 1; i <= r; i++) {
                if (a[i] < a[l]) {
                    // pivot is always the value < a[l]
                    Util.swap(a, i, ++pivot);
                }
            }
            Util.swap(a, l, pivot);
            quickSort(a, l, pivot - 1);
            quickSort(a, pivot + 1, r);
        }
    }
}
