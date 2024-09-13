package com.code.problemset.problem_208;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.getEnd();
    }

    public boolean startsWith(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

}

class TrieNode {

    // 纯小写字母
    private final int size = 26;

    private TrieNode[] children;

    // 是否为完整单词
    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[size];
    }

    public boolean containsKey(char c) {
        return children[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return children[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        children[c - 'a'] = node;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }
}
