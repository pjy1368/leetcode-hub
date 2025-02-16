class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();

        if (total % 2 != 0) {
            return false;
        }

        int subSetSum = total / 2;
        Boolean[][] memo = new Boolean[nums.length + 1][subSetSum + 1];
        return dfs(nums, nums.length - 1, subSetSum, memo);
    }

    private boolean dfs(int[] nums, int idx, int subSetSum, Boolean[][] memo) {
        if (subSetSum == 0) {
            return true;
        }
        if (idx == 0 || subSetSum < 0) {
            return false;
        }

        if (memo[idx][subSetSum] != null) {
            return memo[idx][subSetSum];
        }

        boolean result = dfs(nums, idx - 1, subSetSum - nums[idx - 1], memo) || dfs(nums, idx - 1, subSetSum, memo);

        memo[idx][subSetSum] = result;
        return result;
    }
}