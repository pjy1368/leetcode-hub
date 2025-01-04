class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        
        String before = builder.toString();
        String after = builder.reverse().toString();
        return before.equals(after);
    }
}