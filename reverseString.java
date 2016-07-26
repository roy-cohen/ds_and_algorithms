public class Solution {
    public String reverseString(String s) {
        char[] str = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++){
            str[s.length() - 1 - i] = s.charAt(i);
        }
        
        return new String(str);
    }
}