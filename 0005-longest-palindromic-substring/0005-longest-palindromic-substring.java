class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        String answer = "";
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = true;
                    if (answer.length() < len) {
                        answer = s.substring(i, j + 1);
                    }
                } else if (len == 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (answer.length() < len) {
                            answer = s.substring(i, j + 1);
                        }
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (answer.length() < len) {
                            answer = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return answer;
    }
}