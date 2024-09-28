package LeetCode;



class WordDictionary {

    // TrieNode class to represent each node of the Trie
    class TrieNode {
        TrieNode[] children = new TrieNode[26];  // Each node has 26 possible children (a-z)
        boolean isEndOfWord = false;             // Marks the end of a word
    }

    private TrieNode root;

    /** Initialize the data structure. */
    public WordDictionary() {
        root = new TrieNode();  // Root node of the Trie
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';  // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();  // Create a new node if it doesn't exist
            }
            node = node.children[index];  // Move to the next node
        }
        node.isEndOfWord = true;  // Mark the end of the word
    }

    /** Returns true if there is any string in the data structure that matches word. */
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    /** Helper function to search in the Trie. */
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // '.' can match any character, so we need to search all possible children
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                // If it's a regular character, find the corresponding child node
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;  // If the character doesn't exist, the word can't match
                }
                node = node.children[index];  // Move to the next node
            }
        }
        return node.isEndOfWord;  // At the end of the word, check if it's a valid word
    }
}
