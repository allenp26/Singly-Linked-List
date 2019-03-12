
public class Node<T extends Comparable<T>>  {
    private T data;
    private Node<T> next;

    /**
     * Constructor for objects of class Node
     */
    public Node(T d)
    {
        data = d;
        next = null;
    }

    public Node (T d, Node<T> next) {
        this.next = next;
        data = d;
    }

    /**
     * getter for data
     *
     * @return data
     */
    public T getData() { return data;}

    /**
     * setter for data
     *
     * @param o value of type T
     */
    public void setData(T o) { data = o;}

    /**
     * getter for next node
     *
     * @return next
     */
    public Node<T> getNext() { return next;}

    /**
     * setter for next node
     *
     * @param n value of Node<T>
     */
    public void setNext(Node<T> n) { next = n;}

    /**
     * toString method to print out data contained in the node
     *
     * @return data
     */
    public String toString()
    {
        return getData().toString();
    }
}
