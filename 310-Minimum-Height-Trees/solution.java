public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rst = new ArrayList<>();

        if (edges.length == 0) {
            rst.add(0);
            return rst;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int degree[] = new int[n];

        for (int edge[] : edges) {
            int first = edge[0];
            int second = edge[1];

            degree[first]++;
            degree[second]++;

            addToMap(graph, first, second);
            addToMap(graph, second, first);
        }

        if (graph.size() == 2) {
            rst.addAll(graph.keySet());
        }

        Queue<Integer> leaf = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                leaf.add(i);
        }

        while (!leaf.isEmpty()) {
            int len = leaf.size();
            Queue<Integer> next = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                int curr = leaf.poll();

                next.addAll(removeLeaf(curr, graph, degree));
            }

            if (graph.size() > 2)
                leaf = next;
        }

        rst.addAll(graph.keySet());
        return rst;
    }

    private Queue<Integer> removeLeaf(int curr, Map<Integer, Set<Integer>> graph, int[] degree) {
        Set<Integer> tos = graph.get(curr);
        Queue<Integer> next = new LinkedList<>();

        for (int to : tos) {
            graph.get(to).remove(curr);
            degree[to]--;

            if (degree[to] == 1)
                next.add(to);
        }

        graph.remove(curr);

        return next;
    }

    private void addToMap(Map<Integer, Set<Integer>> map, int i, int j) {
        if (!map.containsKey(i)) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(j);
            map.put(i, tmp);
        } else {
            map.get(i).add(j);
        }
    }
}