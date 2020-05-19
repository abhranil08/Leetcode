class pair {
    int p;
    int s;
    pair(int p,int s)
    {
        this.p=p;
        this.s=s;
    }
}
class StockSpanner {
    
    Stack<pair> st;
    public StockSpanner() {
        st = new Stack<>();      
    }
    
    public int next(int price) {
        int span=1;
        while(!st.isEmpty() && st.peek().p<=price)
            span+=st.pop().s;
        
        st.push(new pair(price,span));
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
