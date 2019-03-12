import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class SLL<T extends Comparable<T>> implements Iterable<T>, Iterator<T> {
    private Node <T> head;
    private Node <T> tail;
    private Node <T> curr;
    private Node <T> last;
    private Comparator freqComp;
    private int size;

    /**
     * Basic constructor which sets all variables to zero or null
     */
    public SLL() {
        head = null;
        tail = null;
        curr = null;
        last = null;
        size = 0;

    }

    /**
     * getter for the size of the list
     *
     * @return size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Adds elements to list using Insertion Sort, which sorts
     * ingredients in alphabetical order
     *
     * @param n value of type T
     */
    public void add(T n) {

        //empty list, add to head
        if (head == null) {
            head = new Node<>(n, null);
        }
        else {
            // check if the new value is lower than head node
            if (n.compareTo(head.getData()) < 0) {
                Node<T> temp = new Node<>(head.getData(), head.getNext());
                head = new Node<>(n, temp);
            }
            else {

                //loop through list to find the right place to insert new value
                Node<T> lastNode = head;
                Node<T> nextNode = head.getNext();
                while (nextNode != null) {
                    if (n.compareTo(nextNode.getData()) < 0) {
                        Node<T> temp = new Node<>(n, nextNode);
                        lastNode.setNext(temp);
                        incrementSize();
                        return;
                    }
                    lastNode = nextNode;
                    nextNode = nextNode.getNext();
                }

                //new value is greater than all nodes
                Node<T> temp = new Node<T>(n, null);
                lastNode.setNext(temp);
            }
        }
        incrementSize();
    }

    /**
     * simple checker to see if the list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (head==null);
    }

    /**
     * increment the size of linked list
     */
    private void incrementSize() {
        size++;
    }

    /**
     * get element's value by index
     *
     * @param index integer of index
     * @return data at specific index
     */
    public T get(int index) {

        if (index < size) {
            Node<T> each = head;
            for (int i = 0; i < size; i++) {
                if (i == index) return each.getData();
                each = each.getNext();
            }
            return null;
        }

        return null;
    }

    /**
     * add new node to the head of the list
     *
     * @param n value of Node<T>
     */
    private void addHead(Node<T> n) {
        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            Node<T> curr = head;
            n.setNext(curr);
            head = n;
        }
    }

    /**
     * add new node to the tail of the list
     *
     * @param n value of Node<T>
     */
    private void addTail(Node<T> n) {
        if (tail == null) {
            head = n;
            tail = n;
        }
        else {
            tail.setNext(n);
            tail = n;
        }
    }


    /**
     * sort method to add new foods to the list based on the frequency
     *
     * @param n value of T
     * @param c comparator
     */
    public void sortFoodFreq(T n, Comparator<T> c) {
        // empty list
        Node<T> addNode = new Node<T>(n, null);
        if (head == null) {
            addHead(addNode);
        }
        else if (c.compare(addNode.getData(), head.getData()) <= 0) {
            addNode.setNext(head);
            head = addNode;
        }
        else {
            Node<T> curr = head;
            while (curr.getNext() != null && c.compare(curr.getNext().getData(), n) <= 0) {
                curr = curr.getNext();
            }
            if (curr.getNext() == null) {
                addTail(addNode);
            }
            else {
                addNode.setNext(curr.getNext());
                curr.setNext(addNode);
            }
        }

        incrementSize();

    }


    /**
     * size of the list
     *
     * @return size
     */
    public int size() {
        return getSize();
    }

    @Override
    public Iterator<T> iterator() {
        curr = head;
        return this;
    }

    @Override
    public T next() {
        T n = curr.getData();
        curr = curr.getNext();

        return n;
    }

    @Override
    public boolean hasNext() {
        return (curr != null);
    }

    @Override
    public String toString() {
        String output = "";

        if (head != null) {
            Node<T> curr = head;
            while (curr != null) {
                output += curr.getData().toString();
                curr = curr.getNext();
            }
        }

        return output;

    }
}
