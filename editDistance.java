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
    String str1 = "azced";
    String str2 = "abcdef";
    System.out.println("From " + str1 + " to " + str2);
    int distance = editDistance(str1, str2);
    System.out.print("Distance = " + distance);                   
  }
  
  public static int editDistance(String str1, String str2) {

        int[][] T = new int[str1.length()][str2.length()];

        if (str1.charAt(0) != str2.charAt(0)) T[0][0] = 1;

        for (int i = 1; i < T.length; i++) T[i][0] = T[i - 1][0] + 1;
        for (int j = 1; j < T[0].length; j++) T[0][j] = T[0][j - 1] + 1;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {

                if (str1.charAt(i) == str2.charAt(j))
                    T[i][j] = T[i - 1][j - 1];
                else
                    T[i][j] = Math.min(T[i - 1][j - 1], Math.min(T[i - 1][j], T[i][j - 1])) + 1;
            }
        }

        //printMatrix(T);
        printChanges(str1, str2, T);
        return T[str1.length() - 1][str2.length() - 1];
    }
  
  private static void printChanges(String str1, String str2, int[][] T) {

        int i = str1.length() - 1;
        int j = str2.length() - 1;
        Stack<String> changes = new Stack<>();

        while (i >= 0 && j >= 0) {

            if (str1.charAt(i) == str2.charAt(j)) {
                i--;
                j--;
                continue;
            }

            int minI = i - 1;
            int minJ = j - 1;
            if (T[i][j - 1] < T[minI][minJ]) {
                minI = i;
                minJ = j - 1;
            }
            if (T[i - 1][j] < T[minI][minJ]) {
                minI = i - 1;
                minJ = j;
            }

            if (minI == i - 1 && minJ == j - 1) {
                changes.push(str1.charAt(i) + " changed to " + str2.charAt(j));
            } else if (minI == i && minJ == j - 1) {
                changes.push(str2.charAt(j) + " inserted");
            } else {
                changes.push(str1.charAt(i) + " deleted");
            }

            i = minI;
            j = minJ;
        }

        while (!changes.empty()) {
            System.out.println(changes.pop());
        }
    
        System.out.println();
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
