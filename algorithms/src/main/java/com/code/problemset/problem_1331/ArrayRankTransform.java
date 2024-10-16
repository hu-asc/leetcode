package com.code.problemset.problem_1331;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-09
 */
public class ArrayRankTransform {


    /**
     * 使用有序 map 保存元素出现的下标
     *
     */
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!treeMap.containsKey(arr[i])) {
                treeMap.put(arr[i], new ArrayList<>());
            }
            treeMap.get(arr[i]).add(i);
        }
        int rank = 1;
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            List<Integer> indexes = treeMap.get(entry.getKey());
            for (Integer index : indexes) {
                arr[index] = rank;
            }
            rank++;
        }
        return arr;
    }

}
