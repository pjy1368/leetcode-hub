class Solution {

    private List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> map = Map.of(
            2, List.of("a", "b", "c"),
            3, List.of("d", "e", "f"),
            4, List.of("g", "h", "i"),
            5, List.of("j", "k", "l"),
            6, List.of("m", "n", "o"),
            7, List.of("p", "q", "r", "s"),
            8, List.of("t", "u", "v"),
            9, List.of("w", "x", "y", "z")
        );

        recursive(0, digits, map, new ArrayList<>());
        return answer;
    }

    private void recursive(int idx, String digits, Map<Integer, List<String>> map, List<String> result) {
        if (idx == digits.length()) {
            answer.add(String.join("", result));
            return;
        }

        List<String> values = map.get(digits.charAt(idx) - '0');
        for (String value : values) {
            result.add(value);
            recursive(idx + 1, digits, map, result);
            result.remove(result.size() - 1);
        }
    }
}