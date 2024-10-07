package leetcode75;

public class Trie_208 {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean endOfWord = false;

        public TrieNode getTrieNode(char value) {
            return children[value-'a'];
        }

        public void addTrieNode(char value, TrieNode node) {
            children[value-'a'] = node;
        }

    }

    private TrieNode root;
    public Trie_208() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            TrieNode newNode = curr.getTrieNode(c);

            if(newNode == null) {
                newNode = new TrieNode();
                curr.addTrieNode(c, newNode);
            }
            curr = newNode;
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        int index = 0;
        while(index < word.length()) {
            if(curr == null) {
                return false;
            }
            TrieNode next = curr.getTrieNode(word.charAt(index));
            curr = next;
            index++;
        }

        return curr != null && curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int index = 0;
        while (index < prefix.length()) {
            if(curr == null) return false;

            TrieNode next = curr.getTrieNode(prefix.charAt(index));
            curr = next;
            index++;
        }

        return curr != null;
    }
}
