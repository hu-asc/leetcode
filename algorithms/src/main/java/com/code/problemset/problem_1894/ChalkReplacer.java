package com.code.problemset.problem_1894;

/**
 * @author huhongtao
 * @date 2024-10-16
 */
public class ChalkReplacer {

    /**
     * k % sum 可以多轮后的最终剩余粉笔数
     * 然后判断剩余粉笔数在哪个学生编号
     */
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        long mod = k % sum;
        int no = 0;
        sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            // 不能使用 <=，= 表示当前学生正好使用完粉笔，则下一个学生需要补粉笔
            if (mod < sum) {
                no = i;
                break;
            }
        }
        return no;
    }
}
