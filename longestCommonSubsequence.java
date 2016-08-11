import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    
    int lcs = longestCommonSubsequence("abcdaf", "acbcf"); //4 abcf
    System.out.println("Length of lcs: " + lcs);
  }
  
  public static int longestCommonSubsequence(String str1, String str2) {

        int[][] T = new int[str1.length()][str2.length()];

        if (str1.charAt(0) == str2.charAt(0)){
            T[0][0] = 1;
        }

        for (int i = 1; i < T.length; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                T[i][0] = 1;
            }else{
                T[i][0] = T[i - 1][0];
            }
        }

        for (int j = 1; j < T[0].length; j++) {
            if (str2.charAt(j) == str1.charAt(0)) {
                T[0][j] = 1;
            }else{
                T[0][j] = T[0][j - 1];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {

                if (str1.charAt(i) == str2.charAt(j)){

                    T[i][j] = T[i - 1][j - 1] + 1;

                }else{

                    T[i][j] = Math.max(T[i][j-1],T[i-1][j]);
                }
            }
        }

        //printMatrix(T);
        int max = T[str1.length() - 1][str2.length() - 1];
        printSubstring(str1, str2, T, max);
        return max;
  }
  
  private static void printSubstring(String str1, String str2, int[][] T, int len) {

        char[] arr = new char[len];
        int index = len - 1;
        int i = T.length - 1;
        int j = T[0].length - 1;

        while (i >= 0 && j >= 0) {

            if (str1.charAt(i) == str2.charAt(j)) {

                arr[index--] = str1.charAt(i);
                i--;
                j--;

            } else {

                if (i == 0) {
                    j--;
                } else if (j == 0) {
                    i--;
                } else if (T[i - 1][j] > T[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println("Longest common subsequence: " + new String(arr));
    }
  
  
  private static void printMatrix(int[][] T) {

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[0].length; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
    }
}
