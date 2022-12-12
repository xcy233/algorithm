package chapter6;

import util.Util;

/**
 * Created by john.xu at 2022-12-09 16:07
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {1,3,2,4,5,7,6,8,10,13,15,12};
        int heapLength = a.length;
        while (heapLength > 0) {
            buildMaxHeap(a, heapLength);
            Util.swap(a, 0, heapLength - 1);
            heapLength--;
        }
        System.out.println(Util.array2Str(a, 0, a.length - 1));
    }

    private static void maxHeapify(int[] a, int position, int heapLength) {
        int maxIdx = position;
        // first, find the largest in three nodes
        if (2 * position < heapLength && a[position] < a[2 * position]) {
            maxIdx = 2 * position;
        }
        if (2 * position + 1 < heapLength && a[maxIdx] < a[2 * position + 1]) {
            maxIdx = 2 * position + 1;
        }
        if (maxIdx != position) {
            // move largest node to root
            Util.swap(a, position, maxIdx);
            maxHeapify(a, maxIdx, heapLength);
        }
    }

    private static void buildMaxHeap(int[] a, int heapLength) {
        for (int i = heapLength / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, heapLength);
        }
    }
}
