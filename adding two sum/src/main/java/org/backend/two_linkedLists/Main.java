package org.backend.two_linkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {

    // The core logic to add two linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummyHead.next;
    }

    private static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
// Example: Representing 342 (stored as 2 -> 4 -> 3)
        ListNode l1 = createLinkedList(new int[]{2, 4, 3});

        // Example: Representing 465 (stored as 5 -> 6 -> 4)
        ListNode l2 = createLinkedList(new int[]{5, 6, 4});

        System.out.println("List 1: ");
        printList(l1);

        System.out.println("List 2: ");
        printList(l2);

        // Calculate the sum
        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Sum List: ");
        printList(result);
    }
}


