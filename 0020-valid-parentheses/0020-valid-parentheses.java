class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                brackets.push(c);
            } else {
                if (brackets.isEmpty()) {
                    return false;
                }

                char top = brackets.peek();

                if (c == ')' && top == '(') {
                    brackets.pop();
                } else if (c == '}' && top == '{') {
                    brackets.pop();
                } else if (c == ']' && top == '[') {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }
}