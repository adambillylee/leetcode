public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList();
        
        helper(rst, new ArrayList<Integer>(), 0, n, k);
        
        return rst;
    }
    
    public void helper(List<List<Integer>>rst , List<Integer> list, int index, int n, int k) {
        if (list.length() == k) {
            rst.add(new ArrayList(list));
            return;
        }
        
        for (int i = index+1; i<n; i++) {
            list.add(i);
            helper(rst, list, i+1, n, k);
            list.remove(list.size()-1);
        }
    }
}