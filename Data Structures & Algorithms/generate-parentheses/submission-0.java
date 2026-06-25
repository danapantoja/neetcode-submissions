class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(n,output,curr, 0,0);
        return output;
    }
    public void backtrack(int n, List<String> output,  StringBuilder curr, int open, int close){
        
        if (open==n && close ==n){
            output.add(curr.toString());
            return;
        }
        
        if (open <n){
            curr.append('(');
            backtrack(n, output, curr, open+1, close);
            curr.deleteCharAt(curr.length()-1);
        }
        if (close < open){
            curr.append(')');
            backtrack(n, output, curr, open, close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
