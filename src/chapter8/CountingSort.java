package chapter8;

import util.Util;

/**
 * Created by john.xu at 2022-12-14 21:39
 */
public class CountingSort {

    // Use a temp array. It's index represents the real element in the original array.
    // We count all the elements in the original array, and find the right position.
    public static void main(String[] args) {
        int[] a = {1,3,2,4,5,7,6,8,10,13,15,12};
        int k = 15;
        int[] result = new int[a.length];
        int[] tmp = new int[k + 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            tmp[a[i]] += 1;
        }
        for (int i = 1; i <= k; i++) {
            tmp[i] = tmp[i] + tmp[i - 1];
        }
        for (int i = 0; i < a.length; i++) {
            // for a[i]
            // tmp[a[i]] is element count less or equal then a[i]
            result[tmp[a[i]] - 1] = a[i];
            tmp[a[i]]--;
        }
        System.out.println(Util.array2Str(result, 0, result.length - 1));
    }

}
