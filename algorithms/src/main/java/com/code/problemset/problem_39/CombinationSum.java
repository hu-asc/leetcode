package com.code.problemset.problem_39;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class CombinationSum {

    /**
     * 回溯
     *
     * 如果不传入 start，则返回的结果会重复
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmp, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], result, tmp, i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmp, int start) {
        if (start == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        // 不选 start
        dfs(candidates, target, result, tmp, start + 1);
        // 选 start
        tmp.add(candidates[start]);
        dfs(candidates, target - candidates[start], result, tmp, start);
        tmp.remove(tmp.size() - 1);
    }
}
