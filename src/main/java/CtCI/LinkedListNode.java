package CtCI;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode() {
        this.next = null;
    }

    public LinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListNode that = (LinkedListNode) o;

        if (value != that.value) return false;
        return next != null ? next.equals(that.next) : that.next == null;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
