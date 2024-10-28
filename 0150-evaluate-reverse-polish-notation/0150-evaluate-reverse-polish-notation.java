class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")){
                int second = st.pop();
                int first = st.pop();
                if(s.equals("+")){
                    st.push(first+second);
                }
                else if(s.equals("*")){
                    st.push(first*second);
                }
                else if(s.equals("/")){
                    st.push(first/second);
                }
                else if(s.equals("-")){
                    st.push(first-second);
                }
            }else{
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        return st.pop();
    }
}