class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int pivot = left;

        int ans1 = binarySearch(nums, 0, pivot - 1, target);
        int ans2 = binarySearch(nums, pivot, nums.length - 1, target);

        if (ans1 == -1 && ans2 == -1) {
            return -1;
        }
        return ans1 != -1 ? ans1 : ans2;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}