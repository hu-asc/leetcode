package com.code.problem_208;

public class TrieTest {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean f1 = trie.search("apple");// 返回 True
        boolean f2 = trie.search("app");// 返回 False
        boolean f3 = trie.startsWith("app"); // 返回 True
        trie.insert("app");
        boolean f4 = trie.search("app");     // 返回 True

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);

    }
}
