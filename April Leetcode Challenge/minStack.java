class Node {
    int val;
    int min;
    Node next;
    
    public Node(int value)
    {
        val=value;
        min=val;
        next=null;
    }
    
}
class MinStack {

    /** initialize your data structure here. */
    Node head;
    
    public MinStack() {
        head=null;
    }
    
    public void push(int x) {
        Node newNode = new Node(x);
        if(head==null)
            head=newNode;
        else
            newNode.next=head;
        
        newNode.min=Math.min(x,head.min);
        head=newNode;
        
        
    }
    
    public void pop() {
        head=head.next;
        
    }
    
    public int top() {
        return head.val;
        
    }
    
    public int getMin() {
        return head.min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
