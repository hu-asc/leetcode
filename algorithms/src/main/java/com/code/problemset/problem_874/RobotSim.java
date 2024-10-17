package com.code.problemset.problem_874;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huhongtao
 * @date 2024-10-17
 */
public class RobotSim {

    /**
     * 哈希表
     *
     * 需要根据当前方向判断 commands[i] 的操作
     *
     * int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
     * 需要罗列所有方向对应的操作
     *
     * obstacles[i] 从 -30000 到 30000,用该 obstacleHash 值能保证 obstacles[i] 转成唯一的 int
     *
     * obstacleHash > 60000 即可
     * 遍历 commands，模拟机器人的行走流程即可
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 0-north, 1-east, 2-south, 3-west
        int currentDirection = 0;
        int[] currentPosition = new int[]{0, 0};
        int max = 0;
        Set<Integer> obstacleSet = new HashSet<>();
        int obstacleHash = 60001;
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] * obstacleHash + obstacle[1]);
        }
        for (int command : commands) {
            if (command == -1) {
                // 右
                currentDirection = (currentDirection + 1) % 4;
                continue;
            }
            if (command == -2) {
                // 左
                currentDirection = (currentDirection + 3) % 4;
                continue;
            }
            int[] direction = directions[currentDirection];
            for (int step = 0; step < command; step++) {
                int nextX = currentPosition[0] + direction[0];
                int nextY = currentPosition[1] + direction[1];
                if (obstacleSet.contains(nextX * obstacleHash + nextY)) {
                    break;
                }
                currentPosition[0] = nextX;
                currentPosition[1] = nextY;
            }
            max = Math.max(max, currentPosition[0] * currentPosition[0] + currentPosition[1] * currentPosition[1]);
        }
        return max;
    }

}
