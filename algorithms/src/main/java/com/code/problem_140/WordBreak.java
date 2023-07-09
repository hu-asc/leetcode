package com.code.problem_140;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        dfs(s, wordDict, result);
        return result;
    }

    private void dfs(String s, List<String> wordDict, List<String> result) {
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                dfs(s.substring(word.length()), wordDict, result);
            }
        }
    }
}
