package com.code.problem_127;

import java.util.*;

public class LadderLength {

    /**
     * bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < poll.length(); j++) {
                    char[] word = poll.toCharArray();
                    for (char c = 'a'; c < 'z'; c++) {
                        word[j] = c;
                        String check = new String(word);
                        if (!check.equals(poll) && wordList.contains(check)) {
                            queue.offer(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }


    public static void main(String[] args) {
        LadderLength t = new LadderLength();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int i = t.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
    }
}
