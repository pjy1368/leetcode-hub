class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];

            // n2 + n3 = -n1 만족하는 n2, n3 찾기
            List<List<Integer>> result = twoPointer(Arrays.copyOfRange(nums, i + 1, nums.length), -n1);
            if (!result.isEmpty()) {
                for (List<Integer> pair : result) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(n1, pair.get(0), pair.get(1)));
                    set.add(list);
                }
            }
        }
        return set.stream().toList();
    }

    private List<List<Integer>> twoPointer(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                result.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}