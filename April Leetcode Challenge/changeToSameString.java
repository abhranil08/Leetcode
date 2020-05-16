class Solution {
    public String changeToSameString(String s)
    {
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> h=new HashMap<>();
        for(String s:strs)
        {
            String con=changeToSameString(s);
            if(!h.containsKey(con))
            {
                List<String> l=new LinkedList<String>();
                l.add(s);
                h.put(con,l);
            }
            else
            {
                List<String> l=h.get(con);
                l.add(s);
                h.put(con,l);
            }
        }
        List<List<String>> ll=new LinkedList<List<String> >();
        
        for(Map.Entry<String,List<String>> iterator: h.entrySet())
        {
            ll.add(iterator.getValue());
            System.out.println(iterator.getValue());
        }
        
        return ll;
        
    }
}
