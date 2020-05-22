class pair {
    char ch;
    int val;
    pair(char ch, int val)
    {
        this.ch=ch;
        this.val=val;
    }
}
class sortCharactersByFreq {
    public String frequencySort(String s) {
        
        //HashMap - Store frequency of each character - Time : O(n)
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!h.containsKey(c))
                h.put(c,1);
            else
                h.put(c,h.get(c)+1);
        }
        
        //Priority Queue of pair : Key --> Characters, Value --> Frequency
        PriorityQueue<pair> pq=new PriorityQueue<>(new Comparator<pair>() {
            public int compare(pair obj1, pair obj2)
            {
                if(obj1.val<=obj2.val)
                    return 1;
                else
                    return -1;
            }
        });
        
        // Frequency wise sorting done using Priority Queue
        // Time : O(m log m) where m --> unique characters
        for(Map.Entry<Character,Integer> i:h.entrySet())
            pq.add(new pair(i.getKey(),i.getValue()));
            
        StringBuilder ans=new StringBuilder();
        while(pq.size()!=0)
        {
            pair m = pq.poll();
            char ele = m.ch;
            int totalFrequency = m.val;
            while(totalFrequency-->0)
                ans.append(ele);
        }
        return ans.toString();
        
        
    }
}
