import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> palindromeMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            palindromeMap.put(c, palindromeMap.getOrDefault(c, 0) + 1);
        }

        boolean allOdd = palindromeMap.values().stream().allMatch(value -> value % 2 == 1);
        if (allOdd) {
            return palindromeMap.values().stream().reduce(0, Integer::sum);
        }

        int palindromeLength = 0;
        while (true) {
            boolean flag = false;
            for (Map.Entry<Character, Integer> entry : palindromeMap.entrySet()) {
                if (entry.getValue() > 1) {
                    palindromeLength += 2;
                    palindromeMap.put(entry.getKey(), entry.getValue() - 2);
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }

        boolean isOne = false;
        for (int value : palindromeMap.values()) {
            if (value == 1) {
                isOne = true;
                break;
            }
        }

        return palindromeLength + (isOne ? 1 : 0);
    }
}