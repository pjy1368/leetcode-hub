class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(new ArrayList<>(), candidates, target, 0, ans);
        return ans;
    }

    private void recursive(List<Integer> arr, int[] candidates, int target, int start, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            arr.add(candidates[i]);
            recursive(arr, candidates, target - candidates[i], i, ans);
            arr.removeLast();
        }
    }
}