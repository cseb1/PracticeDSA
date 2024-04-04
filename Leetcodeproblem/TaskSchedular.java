package Leetcodeproblem;

import java.util.Arrays;

//https://leetcode.com/problems/task-scheduler/description/
public class TaskSchedular {
    public static int leastInterval(char[] tasks, int n) {
        int[] taskFreqMp = new int[26];
        for (char c : tasks) {
            taskFreqMp[c - 'A']++;
        }
        System.out.println(Arrays.toString(taskFreqMp));
        Arrays.sort(taskFreqMp);
        int batchCnt = taskFreqMp[25];
        int vacantSlots = --batchCnt * n;
        for (int indx = 0; indx < 25; indx++) {
            vacantSlots -= Math.min(taskFreqMp[indx], batchCnt);
        }
        return vacantSlots > 0 ? tasks.length + vacantSlots : tasks.length;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 3));
    }
}
