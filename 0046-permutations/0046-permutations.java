class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>();
        recursive(ans, set, nums);
        return ans;
    }

    private void recursive(List<List<Integer>> ans, Set<Integer> set, int[] nums) {
        if (compareSetAndArray(set, nums)) {
            ans.add(new ArrayList<>(set));
            return;
        }

        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }

            set.add(num);
            recursive(ans, set, nums);
            set.remove(num);
        }
    }

    boolean compareSetAndArray(Set<Integer> set, int[] nums) {
        if (set.size() != nums.length) {
            return false;
        }
        
        for (int num : nums) {
            if (!set.contains(num)) {
                return false;
            }
        }
        
        return true;
    }
}