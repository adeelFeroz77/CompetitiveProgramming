class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,0,0,"",ans);
        return ans;
    }

    public void generate(int n, int left, int right, String s, List<String> ans){
        if(left == n && right == n){
            if(validate(s)){
                ans.add(s);
            }
            return;
        }
        if(left+1 <= n){
            generate(n, left+1, right, s+"(", ans);
        }
        if(right+1 <= n){
            generate(n, left, right+1, s+")", ans);
        }
        return;
    }

    public boolean validate(String s){
        Stack<Character> st = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '('){
                st.push('(');
            }else{
                if(st.isEmpty() ){
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}