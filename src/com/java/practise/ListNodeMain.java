package com.java.practise;

public class ListNodeMain {

    public static void main(String[] args) {

    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode previous = null;
        ListNode next = null;
        ListNode current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
