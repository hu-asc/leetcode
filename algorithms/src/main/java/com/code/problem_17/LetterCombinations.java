package com.code.problem_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    /**
     * 回溯
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinations("", digits, 0, map, result);
        return result;
    }

    private void letterCombinations(String s, String digits, int index, Map<Character, String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }
        String letters  = map.get(digits.charAt(index));
        for (int i = 0; i < letters .length(); i++) {
            letterCombinations(s + letters.charAt(i), digits, index + 1, map, result);
        }
    }

}
