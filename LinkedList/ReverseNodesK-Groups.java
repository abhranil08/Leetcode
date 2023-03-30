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
    public ListNode reverseKGroup(ListNode head, int k) {  
        if(head==null) return null;

        ListNode curr = head;
        for(int i = 0 ; i < k ; i ++) {
           if(curr != null) {
                curr = curr.next;
           }else {
               // last group found
               return head;
           }
        }

        ListNode prev = null, next = null, cur = head;
        int count=0;
        while(count++<k && cur!= null )
        {
            next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        head.next = reverseKGroup( next, k );
        return prev;
    }
}
