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
            return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        queue.offer(node);
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        visited.put(node, head);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();

            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);

                    UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor, tmp);
                }

                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}