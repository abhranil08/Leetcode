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
    public ListNode reverseListInKGroups(ListNode head, int k ) 
    {
        if( head == null ) return null;
        ListNode prev = null;
        ListNode nextNode = null;
        ListNode cur = head;
        int count = 0;

        while(cur != null && count < k )
        {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
            count++;
        }
        if( nextNode != null )
            head.next = reverseListInKGroups( nextNode, k);

        return prev;
    }
    public ListNode swapPairs(ListNode head) {
        return reverseListInKGroups(head,2);
        
    }
}
