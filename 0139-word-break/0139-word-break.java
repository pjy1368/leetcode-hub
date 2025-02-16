class Solution {

    private Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return recursive(0, s, wordDict);
    }

    private boolean recursive(int idx, String s, List<String> wordDict) {
        if (idx == s.length()) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        char c = s.charAt(idx);
        dp[idx] = false;

        for (String word : wordDict) {
            if (word.charAt(0) != c) {
                continue;
            }

            boolean isSame = true;
            for (int i = 0; i < word.length(); i++) {
                if ((idx + i) >= s.length() || word.charAt(i) != s.charAt(idx + i)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                if (idx + word.length() == s.length() || 
                    recursive(idx + word.length(), s, wordDict)) {
                    dp[idx] = true;
                    break;
                }
            }
        }

        return dp[idx];
    }
}