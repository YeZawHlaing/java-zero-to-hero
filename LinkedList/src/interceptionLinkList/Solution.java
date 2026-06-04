package interceptionLinkList;

// Clean, self-contained ListNode definition
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Loop until the two pointers meet
        while (pointerA != pointerB) {
            // If pointerA reaches the end, redirect it to headB
            // Otherwise, move it to the next node
            pointerA = (pointerA == null) ? headB : pointerA.next;

            // If pointerB reaches the end, redirect it to headA
            // Otherwise, move it to the next node
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either they met at the intersection node, or both are null (no intersection)
        return pointerA;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Creating a common intersected part: 4 -> 5
        ListNode common = new ListNode(4);
        common.next = new ListNode(5);

        // Creating List A: 1 -> 2 -> 3 -> 4 -> 5
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = common; // Intersection starts here

        // Creating List B: 9 -> 4 -> 5
        ListNode headB = new ListNode(9);
        headB.next = common; // Intersection starts here

        // Find intersection
        ListNode intersection = solver.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersected at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}