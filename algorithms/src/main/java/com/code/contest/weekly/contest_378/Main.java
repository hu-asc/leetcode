package com.code.contest.weekly.contest_378;

public class Main {

    public int maximumLength(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flag1 = false;
            boolean flag2 = false;
            for (int j = i + 1; j < s.length(); j++) {
                if (c == s.charAt(j) && j - i >= 1) {
                    flag1 = true;
                    break;
                }
                for (int k = j + 1; k < s.length(); k++) {
                    if (c == s.charAt(k) && k - j >= 1) {
                        flag2 = true;
                        break;
                    }
                }
            }
            if (flag1 && flag2) {
                System.out.println(c);
                length++;
                flag1 = false;
                flag2 = false;
            }
        }
        return length == 0 ? -1 : length;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String s = "abcaba";
        int i = main.maximumLength(s);
        System.out.println(i);
    }
}
