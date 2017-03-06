package CtCI.chapter02;

import CtCI.LinkedListNode;

import java.util.Stack;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class Palindrome {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.next = new LinkedListNode(1);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);
        head.next.next.next.next = new LinkedListNode(0);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(LinkedListNode head) {
        if (head == null || head.next == null) return true;

        Stack<LinkedListNode> stack = new Stack<>();
        LinkedListNode walker = head;

        // Push the linked list into the stack
        while (walker != null) {
            stack.push(walker);
            walker = walker.next;
        }

        walker = head;
        while (walker != null) {
            if (walker.value != stack.pop().value) {
                return false;
            }

            walker = walker.next;
        }
        return true;
    }
}
