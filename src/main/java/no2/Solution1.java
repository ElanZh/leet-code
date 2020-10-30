package no2;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Solution1 {
    static void printNode(ListNode l) {
        if (l == null) {
            return;
        }
        System.out.print(l.val + " ");
        printNode(l.next);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9));
        ListNode result = new Solution1().addTwoNumbers(l1, l2);
        printNode(result);
    }

    boolean carry = false;
    ListNode result;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (result == null) {
            result = l1;
        }

        if (l2 != null) {
            l1.val += l2.val;
        }
        if (carry) {
            l1.val += 1;
        }
        if (l1.val >= 10) {
            l1.val -= 10;
            carry = true;
        } else {
            carry = false;
        }
        if (l1.next == null && (l2 == null || l2.next == null)) {
            if (carry) {
                l1.next = new ListNode(1);
            }
            return result;
        }
        if (l1.next == null) {
            l1.next = l2.next;
            return addTwoNumbers(l1.next, null);
        }
        if (l2 == null) {
            return addTwoNumbers(l1.next, null);
        }
        return addTwoNumbers(l1.next, l2.next);
    }
}
