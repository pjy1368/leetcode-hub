import java.math.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();

        int[] merged = newInterval;
        for (int[] interval : intervals) {
            if (interval[1] < merged[0]) {
                answer.add(interval);
            } else if (merged[1] < interval[0]) {
                answer.add(merged);
                merged = interval;
            } else {
                merged[0] = Math.min(merged[0], interval[0]);
                merged[1] = Math.max(merged[1], interval[1]);
            }
        }
        answer.add(merged);
        return answer.toArray(new int[answer.size()][]);
    }
}