class TrieNode {
    String word;
    TrieNode[] next;

    // Initialize your data structure here.
    public TrieNode() {
        word = null;
        next = new TrieNode[27];
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            
            int index;
            if (c == '.') {
                index = 27;
            }else{
                index = c - 'a';
            }

            if (curr.next[index] == null)
                curr.next[index] = new TrieNode();

            curr = curr.next[index];
        }
        curr.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode curr = root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            
            int index;
            if (c == '.') {
                index = 27;
            }else{
                index = c - 'a';
            }

            if (curr.next[index] == null)
                return false;

            curr = curr.next[index];
        }

        return curr.word != null && curr.word.equals(word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");