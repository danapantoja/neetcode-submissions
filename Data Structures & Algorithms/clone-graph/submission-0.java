/*
Definition for a Node.
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
       
        Map<Node,Node> visited = new HashMap<>();
        Node head = dfs(node, visited);
        return head;
    }
    public Node dfs(Node original, Map<Node,Node> visited ){
        if (visited.containsKey(original)){
            return visited.get(original);
        }
        if (original==null) return null;
        Node newNode = new Node();
        
        newNode.val = original.val;
        
        visited.put(original, newNode);
        for (Node neighbor : original.neighbors){
            newNode.neighbors.add(dfs(neighbor, visited));
        }
        
        return newNode;
        
        

    }
}