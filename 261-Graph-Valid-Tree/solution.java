public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0)
            return n==1;

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            if (graph.containsKey(a)) {
                graph.get(a).add(b);
            } else {
                Set<Integer> tmp = new HashSet<>();
                tmp.add(b);
                graph.put(a, tmp);
            }

            if (graph.containsKey(b)) {
                graph.get(b).add(a);
            } else {
                Set<Integer> tmp = new HashSet<>();
                tmp.add(a);
                graph.put(b, tmp);
            }
        }

        Map<Integer, Integer> visited = new HashMap<>();
        int startNode = edges[0][0];
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int len = queue.size();
            Queue<Integer> next = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                int curr = queue.poll();

                if (!visited.containsKey(curr)) {
                    visited.put(curr, depth);
                } else {
                    // do not goes the same node again
                    if (depth - visited.get(curr) == 2)
                        continue;
                    else
                        return false;
                }

                next.addAll(graph.get(curr));
            }
            queue = next;
            depth++;
        }

        return visited.size() == n;
    }
}