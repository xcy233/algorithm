package chapter12;

/**
 * Created by john.xu at 2022-12-20 23:09
 */
public class GenericTreeNode<T> {

    public T v;

    public GenericTreeNode<T> parent;

    public GenericTreeNode<T> left;

    public GenericTreeNode<T> right;

    public GenericTreeNode(T v) {
        this.v = v;
    }

}
