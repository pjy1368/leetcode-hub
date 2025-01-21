/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node result = new Node(node.val);
        recursive(map, node, result);
        return result;
    }

    private void recursive(Map<Node, Node> map, Node node, Node result) {
        if (node == null || map.containsKey(node)) {
            return;
        }

        map.put(node, result);

        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                result.neighbors.add(map.get(neighbor));
            } else {
                Node newNode = new Node(neighbor.val);
                result.neighbors.add(newNode);
                recursive(map, neighbor, newNode);
            }
        }
    }
}