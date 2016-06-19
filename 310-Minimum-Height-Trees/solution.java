public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0 || edges == null) {
            return new ArrayList<>().add(0);
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

        Queue<Integer> leaf = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                leaf.add(i);
        }

        while (!leaf.isEmpty()) {
            int curr = leaf.poll();

            removeLeaf(curr, graph, degree);
        }

        List<Integer> rst = new ArrayList<>();
        rst.addAll(graph.keySet());

        return rst;
    }

    private void removeLeaf(int curr, Map<Integer, Set<Integer>> graph, int[] degree) {
        Set<Integer> tos = graph.get(curr);

        for (int to : tos) {
            graph.get(to).remove(curr);
            degree[to]--;
        }

        graph.remove(curr);
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