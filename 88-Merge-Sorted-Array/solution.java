public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tmp[] = new int[m];
        for (int i=0; i<m; i++) {
            tmp[i] = nums1[i];
        }
        
        
        int i=0;
        int j=0;
        int k=0;
        
        while (k < m+n) {
            if (i == m){
                nums1[k] = nums2[j];
                j++;
                k++;
                continue;
            }
            
            if (j == n) {
                nums1[k] = tmp[i];
                i++;
                k++;
                continue;
            }
            
            if (tmp[i]<nums2[j]) {
                nums1[k] = tmp[i];
                i++;
                k++;
            }else{
                nums1[k] = tmp[j];
                j++;
                k++;
            }
        }
    }
}