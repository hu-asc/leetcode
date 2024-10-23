package com.code.problemset.problem_211;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class WordDictionary {

    private TrieNode root;

    /**
     * 构建 trie 树
     */
    public WordDictionary() {
        root = new TrieNode();
        root.isEnd = false;
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * 匹配到 . 时，然后在 node 的所有 children 中判断下个字符是否匹配
     * 匹配到其他字符，然后匹配下一个字符
     */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] charArray, int k, TrieNode root) {
        if (k == charArray.length) {
            return root.isEnd;
        }
        if (charArray[k] == '.') {
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null && search(charArray, k + 1, root.children[i])) {
                    return true;
                }
            }
        } else {
            return root.children[charArray[k] - 'a'] != null && search(charArray, k + 1, root.children[charArray[k] - 'a']);
        }
        return false;
    }
}

class TrieNode {

    TrieNode[] children = new TrieNode[26];

    boolean isEnd;

}
