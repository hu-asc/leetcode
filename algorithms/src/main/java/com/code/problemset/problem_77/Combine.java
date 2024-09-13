package com.code.problemset.problem_77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine {

    /**
     * 回溯
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(comb));
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(result, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }


    /**
     * 从 n-1 中选 k-1 个然后在加上 n;
     * 从 n -1 中选 k 个;
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combineV2(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new ArrayList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combineV2(n - 1, k - 1);
        for (List<Integer> integers : result) {
            integers.add(n);
        }
        result.addAll(combineV2(n - 1, k));
        return result;
    }

}
