public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        
        while (i < m && j < n){
            
            if (nums1[i] < nums2[j]){
                i++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else{
                set.add(nums1[i++]);
                j++;
            }
        }
        
        return convertIntegers(set);
    }
    
    public static int[] convertIntegers(HashSet<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        int index = 0;
        for (Integer key : integers)
        {
            ret[index++] = key;
        }
        return ret;
    }
}