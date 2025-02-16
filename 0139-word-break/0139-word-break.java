class Solution {

    private boolean answer = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        recursive(0, s, wordDict);
        return answer;
    }

    private void recursive(int idx, String s, List<String> wordDict) {
        if (idx == s.length()) {
            answer = true;
            return;
        }

        char c = s.charAt(idx);

        for (String word : wordDict) {
            if (word.charAt(0) != c) {
                continue;
            }

            // word 모든 자릿수와 c 다음번 자릿수가 같은지 확인
            boolean isSame = true;
            for (int i = 0; i < word.length(); i++) {
                if ((idx + i) >= s.length() || word.charAt(i) != s.charAt(idx + i)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                recursive(idx + word.length(), s, wordDict);
            }
        }
    }
}