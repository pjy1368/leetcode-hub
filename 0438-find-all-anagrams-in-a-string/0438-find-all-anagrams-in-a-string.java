class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int windowSize = p.length();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= s.length() - windowSize; i++) {
            if (i == 0) {
              for (int j = i; j < i + windowSize; j++) {
                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
              }
            } else {
                sMap.put(s.charAt(i - 1), sMap.get(s.charAt(i - 1)) - 1);
                if (sMap.get(s.charAt(i - 1)) == 0) {
                    sMap.remove(s.charAt(i - 1));
                }
                sMap.put(s.charAt(i + windowSize - 1), sMap.getOrDefault(s.charAt(i + windowSize - 1) , 0) + 1);
            }
            if (sMap.equals(pMap)) {
                answer.add(i);
            }
        }
        return answer;
    }
}