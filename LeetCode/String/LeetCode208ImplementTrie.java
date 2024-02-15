package LeetCode.String;

import datastructure.Trie.TrieNode;

public class LeetCode208ImplementTrie {
    private TrieNode root;

    public LeetCode208ImplementTrie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (current.children[currentChar - 'a'] == null) {
                current.children[currentChar - 'a'] = new TrieNode(currentChar);
            }
            current = current.children[currentChar - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (current.children[currentChar - 'a'] == null) return false;
            current = current.children[currentChar - 'a'];
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (current.children[currentChar - 'a'] == null) return false;
            current = current.children[currentChar - 'a'];
        }
        return true;
    }
}
