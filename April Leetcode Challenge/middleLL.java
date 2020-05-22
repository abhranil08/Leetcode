/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class middleLL {
    public ListNode middleNode(ListNode head) {
        ListNode slowptr=head;
        ListNode fastptr=head;
        while(fastptr.next!=null)
        {
            if(fastptr.next.next==null)
                break;
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        if(fastptr.next==null)
            return slowptr;
        else
            return slowptr.next;
        
    }
}
