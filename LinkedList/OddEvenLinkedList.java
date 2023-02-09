/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if( head == null ) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while( odd.next != null && even.next != null )
        {
            ListNode temp1 = odd.next.next;
            ListNode temp2 = even.next.next;
            odd.next = temp1;
            odd=odd.next;
            even.next = temp2;
            even=even.next;
        }
        odd.next = evenHead;
        return head;

     
    }
}
