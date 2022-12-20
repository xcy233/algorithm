package chapter16;

import java.util.ArrayList;

public class GreedyActivitySelector {

    public static void main(String[] args) {
        int[] s = {1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {4,5,6,7,9,9,10,11,12,14,16};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int k = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] >= f[k]) {
                list.add(i);
                k = i;
            }
        }
        list.forEach(i -> System.out.print(i + " "));
    }

}
