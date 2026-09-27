
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == ')') {
                StringBuilder temp = new StringBuilder();

                while (st.peek() != '(') {
                    temp.append(st.pop());
                }

                st.pop(); // remove '('

                for (int j = 0; j < temp.length(); j++) {
                    st.push(temp.charAt(j));
                }
            } else {
                st.push(a);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}