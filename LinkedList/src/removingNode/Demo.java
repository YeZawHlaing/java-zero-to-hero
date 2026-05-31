package removingNode;

public class Demo {

    private static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
        }
    }

    // Change return type to ListNode so we can return the updated head
    public static ListNode removingNode(ListNode head, ListNode node) {
        if (head == null || node == null) return head;
        int value = node.val;

        // Step 1: If the head node itself needs to be removed
        while (head != null && head.val == value) {
            head = head.next; // Shift the head forward
        }

        // Step 2: Remove matching nodes further down the chain
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == value) {
                curr.next = curr.next.next; // Bypass the node
            } else {
                curr = curr.next; // Only advance if we didn't remove a node
            }
        }

        return head;
    }

    // Helper method to print and verify the results
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create the list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4});

        // Create the target node containing the value 2
        ListNode node = new ListNode(2);

        System.out.print("Before removal: ");
        printList(head);

        // Capture the updated head from the method
        ListNode ans = removingNode(head, node);

        System.out.print("After removal:  ");
        printList(ans);
    }
}