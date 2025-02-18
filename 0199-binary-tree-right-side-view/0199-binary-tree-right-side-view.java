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

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        recursive(map, 0, root);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int level = entry.getKey();
            List<Integer> values = entry.getValue();

            for (int i = values.size() - 1; i >= 0; i--) {
                if (values.get(i) != null) {
                    result.add(values.get(i));
                    break;
                }
            }
        }
        return result;
    }

    private void recursive(Map<Integer, List<Integer>> map, int level, TreeNode node) {
        map.computeIfAbsent(level, k -> new ArrayList<>()).add(node == null ? null : node.val);

        if (node == null) {
            return;
        }
        
        recursive(map, level + 1, node.left);
        recursive(map, level + 1, node.right);
    }
}