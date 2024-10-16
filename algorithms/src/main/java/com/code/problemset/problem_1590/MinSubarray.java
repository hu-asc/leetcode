package com.code.problemset.problem_1590;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huhongtao
 * @date 2024-10-12
 */
public class MinSubarray {


    /**
     * 前缀和 + 哈希表
     *
     *
     * 1.子数组的和可以使用前缀和数组 s 的两个元素的差值来表示
     *
     * nums[j] = s[right] - s[left - 1]
     *
     * 2. (x - y) mod p = 0 表示 x 和 y 在模 p 下同余，
     * x mod p = y mod p
     * 当 x < 0，y > 0 时，(x mod p + p) mod p = y mod p
     *
     * 设元素的所有和为 sum
     * 通过前缀和，问题转化为在数组中找到两个数 s[left] 和 s[right]，满足 right - left 最小且
     * s[right] - s[left] 与 sum 在模 p 同余
     *
     * s[right] - s[left] 同余 sum mod p
     * 移项：s[right] - sum 同余 s[left] mod p
     *
     * ((s[right] - sum) mod p + p) mod p = s[left] mod p
     *
     * 用哈希表保存 s[left]， 判断是否存在 ((s[right] - sum) mod p + p)，则区间 [j, i) 是符合条件的数组
     *
     */
    public int minSubarray(int[] nums, int p) {
        int[] sumArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumArray[i + 1] = (sumArray[i] + nums[i]) % p;
        }
        int n = nums.length;
        int ans = nums.length;
        int sum = sumArray[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            map.put(sumArray[i], i);
            // 如果不存在，默认放入 -n, i - j 一定大于 n，不符合条件
            int j = map.getOrDefault((sumArray[i] - sum + p) % p, -n);
            ans = Math.min(ans, i - j);
        }
        return ans < n ? ans : -1;
    }

}
