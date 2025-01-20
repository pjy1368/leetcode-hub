/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        recursive(map, root, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int level = entry.getKey();
            List<Integer> nums = entry.getValue();
            result.add(nums);
        }
        return result;        
    }

    private void recursive(Map<Integer, List<Integer>> map, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(level)) {
            List<Integer> nums = new ArrayList<>();
            nums.add(node.val);
            map.put(level, nums);
        } else {
            List<Integer> nums = map.get(level);
            nums.add(node.val);
            map.put(level, nums);
        }

        recursive(map, node.left, level + 1);
        recursive(map, node.right, level+ 1);
    }
}
