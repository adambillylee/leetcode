/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        mapping.put(node, head);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!mapping.containsKey(neighbor)) {
                    queue.add(neighbor);
                    UndirectedGraphNode cloned = new UndirectedGraphNode(neighbor.label);
                    mapping.put(neighbor, cloned);
                }
                
                mapping.get(curr)
                    .neighbors
                    .add(mapping.get(neighbor));
            }
        }
        
        return head;
    }
}