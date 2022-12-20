package chapter10;

import util.Util;

import java.util.Comparator;

/**
 * Created by john.xu at 2022-12-20 21:54
 */
public class SmallestPriorityQueue<T> {

    private Object[] array;

    private int heapSize;

    private Comparator<T> comparator;

    public SmallestPriorityQueue(int size, Comparator<T> comparator) {
        array = new Object[size];
        heapSize = 0;
        this.comparator = comparator;
    }

    public void enqueue(T element) {
        if (heapSize == array.length) {
            throw new IllegalStateException("queue is full!");
        }
        array[heapSize] = element;
        int i = heapSize;
        int parent = (heapSize - 1) / 2;
        // NOTE keep heapify from bottom-up
        while (parent >= 0 && comparator.compare((T)array[parent],(T)array[i]) > 0) {
            Util.swap(array, parent, i);
            i = parent;
            parent = (parent - 1) / 2;
        }
        heapSize++;
    }

    public T dequeue() {
        if (heapSize <= 0) {
            throw new IllegalStateException("queue is empty!");
        }
        Util.swap(array, 0, heapSize - 1);
        T elem = (T) array[heapSize - 1];
        heapSize--;
        if (heapSize > 0) {
            // NOTE heapify up-down
            minHeapify(0);
        }
        return elem;
    }

    private void minHeapify(int i) {
        int smallest = i;

        if (2 * i + 1 < heapSize && comparator.compare((T)array[2 * i + 1], (T)array[i]) < 0) {
            smallest = 2 * i + 1;
        }
        if (2 * i + 2 < heapSize && comparator.compare((T)array[2 * i + 2], (T)array[smallest]) < 0) {
            smallest = 2 * i + 2;
        }
        if (smallest != i) {
            Util.swap(array, i, smallest);
            minHeapify(smallest);
        }
    }

}
