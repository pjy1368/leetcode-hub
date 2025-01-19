class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            
            map.put(c, end);
            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }
}