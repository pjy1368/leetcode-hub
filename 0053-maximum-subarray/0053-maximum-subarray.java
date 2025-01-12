import java.math.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int subSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (subSum + nums[i] < nums[i]) {
                subSum = nums[i];
            } else {
                subSum += nums[i];
            }
            max = Math.max(max, subSum);
        }

        return max;
    }
}