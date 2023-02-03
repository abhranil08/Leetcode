class Solution {
    public boolean isValid(String s) {

        HashSet<Character> closedBrackets = new HashSet<>();
        closedBrackets.add(')');
        closedBrackets.add(']');
        closedBrackets.add('}');

        HashMap<Character,Character> bracketMapping = new HashMap<>();
        bracketMapping.put('}','{');
        bracketMapping.put(')','(');
        bracketMapping.put(']','[');

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char bracket = s.charAt(i);
            if( closedBrackets.contains(bracket))
            {
                if( st.isEmpty() || bracketMapping.get(bracket) != st.peek())
                    return false;
                else
                    st.pop();
            }
            else
            {
                st.push(bracket);
            } 

        }
        if( !st.isEmpty())
            return false;
        return true;
        
    }
}
