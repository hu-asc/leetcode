package com.code.problemset.problem_1497;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author huhongtao
 * @date 2024-10-09
 */
public class CanArrange {

    /**
     * 统计每个元素 arr[i] mod k 的值 v 的次数
     * arr[i] 可能为负数，所以使用公式 v = (arr[i] % k + k) % k 可将复数余数置为正数
     * 如果为 0，则出现的次数必须为偶数
     * 如果非 0，则 v 和 k - v 出现的次数必须匹配
     */
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        for (int i : arr) {
            int v = (i % k + k) % k;
            remainderCount.put(v, remainderCount.getOrDefault(v, 0) + 1);
        }
        // 判断是否匹配
        for (Map.Entry<Integer, Integer> entry : remainderCount.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key == 0) {
                if (value % 2 != 0) {
                    return false;
                }
            } else {
                Integer count = remainderCount.get(k - key);
                if (!value.equals(count)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 还可使用 排序 + 双指针
     * 将数组元素按照 v = (arr[i] % k + k) % k 取值并排序
     * 判断 v = 0 ，匹配的元素个数必须是偶数个
     * 判断非 0，则使用双指针，开始指针和结尾指针匹配
     */
    public boolean canArrangeV2(int[] arr, int k) {
        Integer[] array = Arrays.stream(Arrays.copyOf(arr, arr.length)).boxed().toArray(Integer[]::new);
        Arrays.sort(array, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 % k + k) % k - (o2 % k + k) % k;
            }
        });

        int start = 0;
        int end = arr.length - 1;
        // 判断为 0
        while (start < end) {
            if (array[start] % k != 0) {
                break;
            }
            if (array[start + 1] % k != 0) {
                return false;
            }
            start += 2;
        }
        // 非0
        while (start < end) {
            if ((array[start] + array[end]) % k != 0) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
