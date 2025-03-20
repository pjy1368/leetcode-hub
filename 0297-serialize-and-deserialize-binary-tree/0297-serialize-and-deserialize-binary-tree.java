/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // preorder 활용, 노드가 null이면 X
    // ex) 1, 2, X, X, 3, 4, X, X, 5, X, X
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        
        return root.val + "," + leftSerialized + "," + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }
    
    private TreeNode deserialize(Queue<String> nodes) {
        String value = nodes.poll();
        
        if (value.equals("X")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(value));
        
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));