class Pair {
    String coord1;
    int coord2;
    public Pair( String coord1, int coord2 )
    {
        this.coord1 = coord1;
        this.coord2 = coord2;
    }
}

class FreqComparator implements Comparator<Pair> {
    public int compare( Pair p1, Pair p2)
    {
        if( p1.coord2 > p2.coord2 )
            return -1;
        else if( p1.coord2 == p2.coord2 )
        {
            return( p1.coord1.compareTo(p2.coord1) );
        }
        return 1;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( 5, new FreqComparator());
        HashMap<String,Integer> h = new HashMap<>();
        List<String> topKFrequentElements = new ArrayList<>();

        for( int i = 0;i< words.length;i++)
        {
            if(!h.containsKey(words[i]))
                h.put(words[i],1);
            else
                h.put(words[i], h.get(words[i])+1);
        }

        for( Map.Entry<String,Integer> mapElement : h.entrySet())
        {
            pq.add( new Pair(mapElement.getKey(), mapElement.getValue()) );
        }

        while( pq.size()!=0 && k-- > 0 )
        {
            topKFrequentElements.add(pq.poll().coord1);
        }
        return topKFrequentElements;      
    }
}
