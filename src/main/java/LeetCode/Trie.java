package LeetCode;

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchWordInNode(word,root);
    }

    public boolean startsWith(String prefix) {
        return searchPrefixInNode(prefix,root);
    }

    private boolean searchWordInNode(String word, TrieNode node){
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;  // If the character doesn't exist, the word can't match
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    private boolean searchPrefixInNode(String word, TrieNode node){
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;  // If the character doesn't exist, the word can't match
            }
            node = node.children[index];
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false; // Each node has 26 possible children (a-z)     // Marks the end of a word
}
