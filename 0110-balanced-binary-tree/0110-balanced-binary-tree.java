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

    private boolean answer = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        recurse(root);
        return answer;
    }

    private void recurse(TreeNode node) {
        if (node == null) {
            return;
        }

        if (Math.abs(calculateHeight(node.left) - calculateHeight(node.right)) > 1) {
            answer = false;
            return;
        }

        recurse(node.left);
        recurse(node.right);
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(calculateHeight(node.left), calculateHeight(node.right)) + 1;
    }
}