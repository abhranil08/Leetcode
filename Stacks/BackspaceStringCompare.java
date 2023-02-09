class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st_1 = new Stack<>();
        Stack<Character> st_2 = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='#')          
            {
                if( !st_1.isEmpty() )
                    st_1.pop();    
            }
            else
                st_1.push(s.charAt(i));
        }

        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='#')
            {
                if( !st_2.isEmpty() )
                    st_2.pop(); 
            }
            else
                st_2.push(t.charAt(i));
        }

        while( !st_1.isEmpty() && !st_2.isEmpty())
        {
            if( st_1.pop() != st_2.pop())
                return false;
        }      
        return( st_1.isEmpty() && st_2.isEmpty());  
    }
}
