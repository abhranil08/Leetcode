class Solution {
    public boolean checkValidString(String s) {
        
        // st1 --> opening braces
        // st2 --> stars
        
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==')')
            {
                if(!st1.isEmpty())
                    st1.pop();
                else if(!st2.isEmpty() && st2.peek()<i)
                    st2.pop();
                else
                    return false;
                
            }
            else if(ch=='(')
                st1.push(i);
            else
                st2.push(i);
                
        }
        
        while(true)
        {
            if(st1.isEmpty() || st2.isEmpty() || st1.peek()>st2.peek())
                break;
            st1.pop();
            st2.pop();
        }
        
        if(st1.isEmpty())
            return true;
        else
            return false;
        
    }
}
