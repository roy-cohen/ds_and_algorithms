public class Solution {
    public int addDigits(int num) {
        
        if (num == 0)
            return 0;
        
        int val = num % 9;
        if (val == 0)
            return 9;
            
        return val;
    }
}