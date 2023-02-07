class TrieNode {
    private HashMap<Character,TrieNode>  children = new HashMap<>();
    private boolean endOfWord;

    public HashMap<Character,TrieNode> getChildren()
    {
        return children;
    }
    public void setEndOfWord( boolean endOfWord )
    {
        this.endOfWord = endOfWord;
    }
    public boolean getEndOfWord()
    {
        return endOfWord;
    }
}

class Trie {
    private TrieNode root;

    Trie()
    {
        root = new TrieNode();
    }

    void insert( String word )
    {
        TrieNode current = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            current = current.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
        current.setEndOfWord( true );
    }

    public int countChildren( TrieNode trieNode )
    {
        return( trieNode.getChildren().size());
    }

    public String walkTree( String word )
    {
        TrieNode current = root;
        int i = 0;
        String prefix="";
        while( countChildren(current) == 1 && current.getEndOfWord() == false)
        {
            char ch = word.charAt(i++);
            TrieNode node = current.getChildren().get(ch);
            prefix += Character.toString(ch);
            current = node;
        }
        return prefix;

    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        int sizeMinLengthWord = -1;
        String minLengthWord = strs[0];


        for(int i = 0; i < strs.length; i++)
        {
            String word = strs[i];
            trie.insert(word);

            if( word.length() < sizeMinLengthWord )
                minLengthWord = word;
        }

        return trie.walkTree( minLengthWord );      
    }
}
