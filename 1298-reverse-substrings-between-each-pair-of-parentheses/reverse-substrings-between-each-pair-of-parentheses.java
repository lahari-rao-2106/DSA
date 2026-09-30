class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c != ')') {
                stack.push(c);
            } 
            else {

                String temp = "";

                while (stack.peek() != '(') {
                    temp += stack.pop();
                }

                stack.pop(); // remove '('

                for (char x : temp.toCharArray()) {
                    stack.push(x);
                }
            }
        }

        String answer = "";

        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }

        return answer;
    }
}