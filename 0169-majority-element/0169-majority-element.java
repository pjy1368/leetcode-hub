class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majorityElement = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count < entry.getValue()) {
                count = entry.getValue();
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
}