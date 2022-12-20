package chapter16;

import chapter10.SmallestPriorityQueue;
import chapter12.GenericTreeNode;

import java.util.Comparator;

/**
 * Created by john.xu at 2022-12-20 21:24
 */
public class Huffman {

    public static void main(String[] args) {
        SmallestPriorityQueue<GenericTreeNode<Character>> queue =
                new SmallestPriorityQueue<GenericTreeNode<Character>>(6, new Comparator<GenericTreeNode<Character>>() {
                    @Override
                    public int compare(GenericTreeNode<Character> o1, GenericTreeNode<Character> o2) {
                        return o1.v.freq - o2.v.freq;
                    }
                });

        queue.enqueue(new GenericTreeNode<>(new Character('c', 12)));
        queue.enqueue(new GenericTreeNode<>(new Character('a', 45)));
        queue.enqueue(new GenericTreeNode<>(new Character('f', 5)));
        queue.enqueue(new GenericTreeNode<>(new Character('e', 9)));
        queue.enqueue(new GenericTreeNode<>(new Character('b', 13)));
        queue.enqueue(new GenericTreeNode<>(new Character('d', 16)));

        //NOTE should be 5 here! After 5 iterations, only last node left in the queue
        for (int i = 0; i < 5; i++) {
            GenericTreeNode<Character> a = queue.dequeue();
            GenericTreeNode<Character> b = queue.dequeue();
            GenericTreeNode<Character> root = new GenericTreeNode<>(new Character('.', a.v.freq + b.v.freq));
            root.left = a;
            root.right = b;
            queue.enqueue(root);
        }
        printResult(queue.dequeue(), "");
    }

    private static void printResult(GenericTreeNode<Character> node, String res) {
        if (node.left != null) {
            printResult(node.left, res + "0");
        }
        if (node.right != null) {
            printResult(node.right, res + "1");
        }
        else {
            System.out.println(node.v.c + ":" + res);
        }
    }

    private static class Character implements Comparable<Character> {
        char c;
        int freq;

        public Character(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Character o) {
            return freq - o.freq;
        }
    }

}
