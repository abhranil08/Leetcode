/*
211. Design Add and Search Words Data Structure
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.

*/

class TrieNode {
    TrieNode children[];
    boolean isEndOfWord;

    public TrieNode()
    {
        children = new TrieNode[26];
        isEndOfWord = false;
        for( int i = 0;i < 26;i++)
        children[i]=null;
    }
}

class Trie {
    TrieNode root = new TrieNode();
    void addWord(String word )
    {
        TrieNode pcrawl = root;
        for( int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            int index = ch-'a';
            if(pcrawl.children[index]==null)
            {
                pcrawl.children[index]=new TrieNode();
            }
            pcrawl = pcrawl.children[index];

        }
        pcrawl.isEndOfWord = true;
    }

    boolean search( String word)
    {
        TrieNode trieNode = root ;
        return search( word, trieNode );
    }
    boolean search( String word, TrieNode trieNode )
    {
        TrieNode pcrawl = trieNode ;
        for(int i =0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            int index = ch-'a';

            if(ch=='.')
            {
                for( TrieNode childrenNode: pcrawl.children)
                    if(childrenNode != null && search(word.substring(i+1), childrenNode)) return true;
                return false;
            }            
            if(pcrawl.children[index]==null)
                return false;
            else
                pcrawl = pcrawl.children[index];            
        }
        return pcrawl != null && pcrawl.isEndOfWord;
        
    }

}
class WordDictionary {
    Trie trie;

    public WordDictionary() {
        this.trie = new Trie();  
    }

    public void addWord(String word) {
        trie.addWord(word);
        
    }
    
    public boolean search(String word) {
        return trie.search(word);
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
