package com.code.problemset.problem_49;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagramsTest {

    @Test
    public void test() {
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<String>(){{
            add("tan");
            add("nat");
        }});
        result.add(new ArrayList<String>(){{
            add("eat");
            add("tea");
            add("ate");
        }});
        result.add(new ArrayList<String>(){{
            add("bat");
        }});
        Assert.assertArrayEquals(result.toArray(new ArrayList[result.size()]), lists.toArray(new ArrayList[lists.size()]));
    }

}
