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

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        recursive(root);
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }

    private void recursive(TreeNode node) {
        if (node == null) {
            return;
        }

        pq.offer(node.val);

        recursive(node.left);
        recursive(node.right);
    }
}