package CtCI.chapter02;

import CtCI.LinkedListNode;
import org.w3c.dom.NodeList;

/**
 * Created by sonnguyen on 2/26/17.
 */
public class SumList {

    public static void main(String[] args) {
        LinkedListNode num1 = new LinkedListNode(7);
        num1.next = new LinkedListNode(1);
        num1.next.next = new LinkedListNode(6);

        LinkedListNode num2 = new LinkedListNode(5);
        num2.next = new LinkedListNode(9);
        num2.next.next = new LinkedListNode(2);

        LinkedListNode result = addLists(num1, num2, 0);
        LinkedListNode resultWalker = result;
        while (resultWalker != null) {
            System.out.println(resultWalker.value);
            resultWalker = resultWalker.next;
        }
    }

    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.value;
        }
        if (l2 != null) {
            value += l2.value;
        }
        result.value = value % 10;
        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }
}
