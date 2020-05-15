class Trie {
    
    Trie[] children = new Trie[26];
    boolean isEndOfWord;

    /** Initialize your data structure here. */
    public Trie() {
        isEndOfWord=false;
        for(int i=0;i<26;i++)
            children[i]=null;
        
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        
        for(int i=0;i<word.length();i++)
        {
            int ch=word.charAt(i)-'a';
            if(curr.children[ch]==null)
            {
                curr.children[ch]=new Trie();
            }
            curr=curr.children[ch];
        }
        curr.isEndOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr=this;
        for(int i=0;i<word.length();i++)
        {
            int ch=word.charAt(i)-'a';
            if(curr.children[ch]==null)
                return false;
            
            curr=curr.children[ch];
            
        }
        
        return (curr!=null && curr.isEndOfWord);
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr=this;
        
        for(int i=0;i<prefix.length();i++)
        {
            int ch=prefix.charAt(i)-'a';
            if(curr.children[ch]==null)
                return false;
            curr=curr.children[ch];
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
