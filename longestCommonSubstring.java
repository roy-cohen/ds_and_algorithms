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
    
    int lcs = longestCommonString("abcdaf", "zbcdf"); 
    System.out.println("Length of lcs: " + lcs);
  }
  
  public static int longestCommonString(String str1, String str2) {

        int[][] T = new int[str1.length()][str2.length()];
        int max = 0;
        int maxI = -1;
        int maxJ = -1;

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[0].length; j++) {

                if (i < str1.length() && j < str2.length()) {

                    if (str1.charAt(i) == str2.charAt(j)) {

                        if (i - 1 >= 0 && j - 1 >= 0) {
                            T[i][j] = T[i - 1][j - 1] + 1;
                        } else {
                            T[i][j] = 1;
                        }

                        if (T[i][j] > max) {
                            max = T[i][j];
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }
        }

        //printMatrix(T);
        String substring1 = str1.substring(maxI - max + 1, maxI + 1);
        //String substring2 = str2.substring(maxJ - max + 1, maxJ + 1);
        System.out.print("Longest common substring: " );    
        System.out.println(substring1);
        //System.out.println(substring2);
        return max;
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
