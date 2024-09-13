package com.code.problemset.problem_139;

import java.util.*;

public class WordBreak {

    /**
     * dfs
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    private boolean dfs(String s, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String nextStr = s.substring(word.length());
                if (nextStr.length() == 0) {
                    return true;
                }
                return dfs(nextStr, wordDict);
            }
        }
        return false;
    }


    /**
     * trie
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakV2(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }
        return dfs(trie, map, s);
    }

    private boolean dfs(Trie trie, Map<String, Boolean> map, String word) {
        Trie tmp = trie;
        if (word.length() == 0 || tmp.search(word)) {
            return true;
        }
        if (map.containsKey(word)) {
            return map.get(word);
        }
        for (int i = 0; i < word.length(); i++) {
            if (tmp.search(word.substring(0, i))) {
                if (dfs(trie, map, word.substring(i))) {
                    map.put(word.substring(i), true);
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean b = wordBreak.wordBreakV2(s, wordDict);
        System.out.println(b);
    }

}


class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!node.containKeys(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.containKeys(c)) {
                node = node.get(c);
            } else {
                node = null;
                return false;
            }
        }
        return node != null && node.getEnd();
    }

}


class TrieNode {

    // 纯小写字母
    private final int size = 26;

    private TrieNode[] children;

    private boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[size];
    }

    public boolean containKeys(char c) {
        return this.children[c - 'a'] != null;
    }

    public void put(char c, TrieNode node) {
        this.children[c - 'a'] = node;
    }

    public TrieNode get(char c) {
        return this.children[c - 'a'];
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean getEnd() {
        return this.isEnd;
    }

}