package com.code.problemset.problem_2491;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huhongtao
 * @date 2024-10-11
 */
public class DividePlayers {


    /**
     * 找出平均数 avg
     *
     * 针对 skill[i]，判断是否存在 avg - skill[i]，如果不存在则不能均分
     *
     * 结果为 skill[i] * (avg - skill[i]) 之和 / 2
     */
    public long dividePlayers(int[] skill) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : skill) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        int n = skill.length;
        long sum = 0;
        for (int i : skill) {
            sum += i;
        }
        long avg = sum / (n / 2);
        // 判断 skill[i] 和 （avg - skill[i]）的次数是否相等
        long result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (!entry.getValue().equals(map.get((int)avg - key))) {
                return -1;
            }
            // 需要乘以 key 出现的次数
            result += entry.getValue() * key * (avg - key);
        }
        return result / 2;
    }

}
