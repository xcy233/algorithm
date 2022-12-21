package chapter16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by john.xu at 2022-12-21 22:30
 */
public class KnapsackFractional {
    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10, 1),
                new Item(100, 20, 2),
                new Item(120, 30, 3)
        };
        int totalW = 50;
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.val / o2.weight - o1.val / o1.weight;
            }
        });
        int currentValue = 0;
        int remain = totalW;
        for (int i = 0; i < items.length; i++) {
            if (items[i].weight <= remain) {
                System.out.println("100% of item " + items[i].number);
                currentValue += items[i].val;
                remain -= items[i].weight;
            } else {
                currentValue += remain * (items[i].val / items[i].weight);
                double fractional = ((double)remain / items[i].weight) * 100;
                System.out.println(fractional + "% of item " + items[i].number);
                System.out.println("max value is : " + currentValue);
                return;
            }
        }
    }

    private static class Item {
        int val;
        int weight;
        int number;
        public Item(int val, int weight, int number) {
            this.val = val;
            this.weight = weight;
            this.number = number;
        }
    }
}
