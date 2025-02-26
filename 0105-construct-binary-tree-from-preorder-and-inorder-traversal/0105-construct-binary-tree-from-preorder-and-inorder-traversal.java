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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursive(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursive(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // preorder의 첫 번째 요소는 현재 서브트리의 루트
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // inorder에서 루트 찾기
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // 왼쪽 서브트리의 크기 계산
        int leftSubTreeSize = rootIndex - inStart;

        // 왼쪽과 오른쪽 서브 트리를 재귀적으로 구축
        // 왼쪽 서브 트리: preorder에서는 루트 다음부터 leftSubSize만큼, inorder에서는 루트 이전까지
        root.left = recursive(preorder, preStart + 1, preStart + leftSubTreeSize, inorder, inStart, rootIndex - 1);

        // 오른쪽 서브트리: preorder에서는 왼쪽 서브트리 이후부터 끝까지, inorder에서는 루트 이후부터 끝까지
        root.right = recursive(preorder, preStart + leftSubTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}