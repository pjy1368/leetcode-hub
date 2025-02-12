class Solution {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;
            } else if (nums[i] == 1) {
                whiteCount++;
            }
        }

        for (int i = 0; i < redCount; i++) {
            nums[i] = 0;
        }

        for (int i = redCount; i < redCount + whiteCount; i++) {
            nums[i] = 1;
        }

        for (int i = redCount + whiteCount; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}