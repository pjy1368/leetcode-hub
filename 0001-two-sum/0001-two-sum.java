import java.util.*;


class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, List<Integer>> numOfIndexs = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      numOfIndexs.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (!numOfIndexs.containsKey(complement)) {
        continue;
      }

      List<Integer> complementIndexs = numOfIndexs.get(complement);

      if (complement == nums[i]) {
        if (complementIndexs.size() > 1) {
          return new int[]{i, complementIndexs.get(1)};
        }
        continue;
      }

      return new int[]{i, complementIndexs.get(0)};
    }
    return null;
  }
}