//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

package leetcode;

public class TwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = makeList("9");
        ListNode l2 = makeList("1999999999");

        reverseTwoNumbers(addTwoNumbers(l1, l2));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode listNode = result;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            int digit = l1.val + l2.val + listNode.val;
            listNode.val = digit % 10;
            listNode.next = new ListNode(digit / 10);
            prev = listNode;
            listNode = listNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = l1 == null ? l2 : l1;
        while (l != null) {
            listNode.val += l.val;
            listNode.next = new ListNode(listNode.val / 10);
            listNode.val %= 10;
            prev = listNode;
            listNode = listNode.next;
            l = l.next;
        }
        if (listNode.val == 0) {
            listNode = prev;
            listNode.next = null;
        }
        return result;
    }
    public static ListNode makeList(String str) {
        ListNode result = new ListNode(Integer.parseInt(str.substring(0, 1)));
        ListNode listNode = result;
        str = str.substring(1);
        while (!str.isBlank()) {
            listNode.next = new ListNode();
            listNode = listNode.next;
            listNode.val = Integer.parseInt(str.substring(0, 1));
            str = str.substring(1);
        }
        return result;
    }
    public static void reverseTwoNumbers(ListNode listNode) {
        if (listNode.next != null)
            reverseTwoNumbers(listNode.next);
        System.out.print(listNode.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
