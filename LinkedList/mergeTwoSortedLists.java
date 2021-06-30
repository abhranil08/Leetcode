/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
*/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode( 0, null );
        ListNode out = result;
        
        while ( l1 != null && l2 != null )
        {                        
            if( l1.val < l2.val )
            {                
                result.next = l1;
                l1 = l1.next;
            }    
            else
            {                
                result.next = l2;
                l2 = l2.next;
            }
            result=result.next;
        }
        while( l2 != null )
        {
            result.next = l2;
            l2 = l2.next;
            result = result.next;                   
        }
        while( l1 != null )
        {
            result.next = l1;
            l1 = l1.next;                  
            result=result.next;
        }
        return( out.next );
        
        
    }
}
