/*
583. Delete Operation for Two Strings
Solved
Medium
Topics
premium lock icon
Companies
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.



Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
*/

package April_25_2026;

import java.util.Scanner;

public class Leetcode_583 {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            //to move from curr to prev
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        int lcs = prev[n];
        return (m+n - 2*lcs);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println(minDistance(word1, word2));
    }
}
