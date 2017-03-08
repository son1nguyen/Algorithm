package CtCI.chapter02;

import CtCI.LinkedListNode;

import javax.swing.*;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class Partition {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(5);
        head.next.next = new LinkedListNode(8);
        head.next.next.next = new LinkedListNode(5);
        head.next.next.next.next = new LinkedListNode(10);
        head.next.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next.next = new LinkedListNode(1);

        head = partition(head, 5);
        LinkedListNode headWalker = head;
        while (headWalker != null) {
            System.out.print(headWalker.value + " ");
            headWalker = headWalker.next;
        }
    }

    private static LinkedListNode partition(LinkedListNode head, int partition) {
        if (head == null) return null;

        LinkedListNode smaller = null;
        LinkedListNode smallerWalker = null;
        LinkedListNode greater = null;
        LinkedListNode greaterWalker = null;

        LinkedListNode headWalker = head;
        while (headWalker != null) {
            if (headWalker.value < partition) {
                if (smaller == null) {
                    smaller = headWalker;
                    smallerWalker = headWalker;
                    headWalker = headWalker.next;
                } else {
                    smallerWalker.next = headWalker;
                    headWalker = headWalker.next;
                    smallerWalker = smallerWalker.next;
                }
                smallerWalker.next = null;
            } else {
                if (greater == null) {
                    greater = headWalker;
                    greaterWalker = headWalker;
                    headWalker = headWalker.next;
                } else {
                    greaterWalker.next = headWalker;
                    headWalker = headWalker.next;
                    greaterWalker = greaterWalker.next;
                }

                greaterWalker.next = null;
            }
        }

        smallerWalker.next = greater;
        return smaller;
    }
}
