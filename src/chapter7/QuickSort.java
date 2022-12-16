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
            int p = partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[l];
        int p = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < pivot) {
                p++;
                Util.swap(a, p, i);
            }
        }
        Util.swap(a, l, p);
        return p;
    }
}
