public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();

        if (numRows == 0)
            return rst;

        rst.add(new ArrayList<>());
        rst.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            rst.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                rst.get(i).add(getNum(i, j, rst));
            }
        }

        return rst;
    }

    private int getNum(int i, int j, List<List<Integer>> rst) {
        int len = rst.get(i - 1).size();

        int left = j - 1 >= 0 ? rst.get(i - 1).get(j - 1) : 0;
        int right = j < len ? rst.get(i - 1).get(j) : 0;

        return left + right;
    }
}