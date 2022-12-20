package chapter10;

/**
 * Created by john.xu at 2022-12-20 21:27
 */
public class Queue<T> {

    Object[] array;

    private int head;

    private int tail;

    public Queue(int size) {
        array = new Object[size];
        head = tail = 0;
    }

    public void enqueue(T element) {
        // NOTE full queue condition
        if (tail + 1 == head) {
            throw new IllegalStateException("queue is full");
        }
        array[tail] = element;
        tail = tail + 1 == array.length ? 0 : tail + 1;
    }

    public T dequeue() {
        if (head == tail) {
            throw new IllegalArgumentException("empty queue!");
        }
        T res = (T)array[head];
        head = head + 1 == array.length ? 0 : head + 1;
        return res;
    }

}
