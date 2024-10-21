package com.code.problemset.problem_1310;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class XorQueries {

    /**
     * 1.模拟整个流程 （会超时）
     * 用前缀异或数组
     *
     * prefixXOR[0]=0(XOR of elements before the start)
     * prefixXOR[1]=a
     * prefixXOR[2]=a⊕b
     * prefixXOR[3]=a⊕b⊕c
     * prefixXOR[4]=a⊕b⊕c⊕d
     * prefixXOR[5]=a⊕b⊕c⊕d⊕e
     * 比如
     * prefixXOR[4]⊕prefixXOR[1]=(a⊕b⊕c⊕d)⊕a=b⊕c⊕d
     *
     *
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] prefixXorResult = new int[arr.length + 1];
        prefixXorResult[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixXorResult[i + 1] = arr[i] ^ prefixXorResult[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = prefixXorResult[query[0]] ^ prefixXorResult[query[1] + 1];
        }
        return result;
    }
}
