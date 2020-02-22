class IsParenthesesValid {
    public boolean isParenthesesValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char match;
                if (c == ')') {
                    match = '(';
                } else if (c == '}') {
                    match = '{';
                } else {
                    assert c == ']';
                    match = '[';
                }

                if (match == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
