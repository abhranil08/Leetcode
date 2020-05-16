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
    public void print(ListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        ListNode ctr=head;
        ListNode ctr1=null;
        ListNode ctr2=null;
        
        ListNode ptr1=null;
        ListNode ptr2=null;
        
        int i=0;
        while(ctr!=null)
        {
            if(i%2==0)
            {
                if(ptr1==null)
                {
                    ptr1=ctr;
                    ctr1=ctr;
                }
                else
                {
                    ctr1.next=ctr;
                    ctr1=ctr1.next;
                }
            }
            else
            {
                if(ptr2==null)
                {
                    ptr2=ctr;
                    ctr2=ctr;
                }
                else
                {
                    ctr2.next=ctr;
                    ctr2=ctr2.next;
                }
            }
            i++;
            ctr=ctr.next;
        }
        if(ctr1!=null)
        ctr1.next=ptr2;
        
        if(ctr2!=null)
        ctr2.next=null;
        
        return ptr1; 
    }
}
