public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap();
        
        // build the freq map
        for (int ele : nums) {
            if (freqMap.get(ele) == null) {
                freqMap.put(ele, 1);
            }else{
                freqMap.put(ele, freqMap.get(ele)+1);
            }
        }
        
        List<Integer> bucket[] = new List[nums.length + 1];
        
        for (int ele : freqMap.keySet()) {
            int freq = freqMap.get(ele);
            
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList();
                
            bucket[freq].add(ele);
        }
        
        List<Integer> rst = new ArrayList();
        
        for (int i=bucket.length-1; i>=0 && rst.size()<k; i--) {
            if (bucket[i] != null)
                rst.addAll(bucket[i]);
        }
        
        return rst;
    }
}