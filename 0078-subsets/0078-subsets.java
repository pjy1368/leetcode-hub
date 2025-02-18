class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        recursive(result, visited, nums, 0);
        return result;
    }

    private void recursive(List<List<Integer>> result, boolean[] visited, int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    list.add(nums[i]);
                }
            }
            result.add(list);
            return;
        }

        visited[idx] = true;
        recursive(result, visited, nums, idx + 1);

        visited[idx] = false;
        recursive(result, visited, nums, idx + 1);
    }
}