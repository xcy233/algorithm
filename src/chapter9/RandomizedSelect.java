package chapter9;

import util.Util;

import java.util.Random;

/**
 * Created by john.xu at 2022-12-16 17:35
 */
public class RandomizedSelect {

    public static void main(String[] args) {
        int[] a = {1,3,2,4,5,7,6,8,10,13,15,12};
        Random random = new Random();
        System.out.println(randomizedSelect(a, 0, a.length - 1, 2, random));
    }

    private static int randomizedSelect(int[] a, int l, int r, int i, Random random) {
        if (l == r) {
            return a[l];
        }
        int p = randomizedPartition(random, a, l, r);
        int k = p - l + 1;
        if (k == i) {
            return a[p];
        } else if (i < k) {
            return randomizedSelect(a, l, p - 1, i, random);
        } else {
            return randomizedSelect(a, p + 1, r, i - k, random);
        }
    }

    private static int randomizedPartition(Random random, int[] a, int l, int r) {
        int rand = random.nextInt(r - l);
        Util.swap(a, r, rand + l);
        return partition(a, l, r);
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
