package duplicateAndRemove;


import java.util.HashSet;

public class ListNode {
     int val;
     public ListNode next;
     ListNode() {}
      public ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



class Solution {
    public static ListNode deleteDuplicates(ListNode head) {

        HashSet<Integer> seen= new HashSet<>();
        ListNode current=head;

        seen.add(current.val);

        while (current != null && current.next != null){
            if (seen.contains(current.next.val)){
                current.next = current.next.next;
            }
            else {
                seen.add(current.next.val);
                current = current.next;
            }
        }

        return head;
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

    public static void main(String args[]){
        ListNode head= new ListNode();
        head=createLinkedList(new int[]{1,2,1,3,1});

        ListNode ans=deleteDuplicates(head);

        System.out.println("Deleted LinkedNode: ");
        System.out.println(ans.val);


    }
}




