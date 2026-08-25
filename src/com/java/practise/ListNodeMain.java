package com.java.practise;

public class ListNodeMain {

    public static void main(String[] args) {

    }

        public static ListNode reverse(ListNode head){
            if(head ==null){
                return head;
            }

            ListNode previous = null;
            ListNode current = head;
            while (head!=null){
                previous = current.next;
                previous.value = current.value;
                previous = current;
            }
            return previous;
        }
}
