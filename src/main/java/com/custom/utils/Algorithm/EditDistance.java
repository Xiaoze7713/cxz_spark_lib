package com.custom.utils.Algorithm;

public class EditDistance {
    public static int GetEditDistance(String s1, String s2) {
        if (s1 == null) {
            s1 = "";
        }
        if (s2 == null ) {
            s2 = "";
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            return 0;
        }
        if (s1.isEmpty()) {
            return s2.length();
        }
        if (s2.isEmpty()) {
            return s1.length();
        }
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        if (s1.length() < s2.length()) {
            String tmp;
            tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int [][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i ++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j ++) {
            dp[0][j] = j;
        }
        for (int i = 1 ;i < s1.length() + 1;i ++) {
            for (int j = 1; j < s2.length() + 1; j ++) {
                int delta = s1.charAt(i-1) == s2.charAt(j-1) ? 0:1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + delta, Math.min(dp[i-1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
