class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        //backtracking functions fills up the output array list
        backtrack(n,output,curr, 0,0);
        //we just have to return the output
        return output;
    }
    public void backtrack(int n, List<String> output,  StringBuilder curr, int open, int close){
        //if we made it, we have n pairs of good parenthesis
        //so we can add the current string builder to the output and return
        if (open==n && close ==n){
            output.add(curr.toString());
            return;
        }
        //if the number of open parenthesis is still less than n, we can continue to add
        if (open <n){
            //we append to current string, and continue with the recursion
            curr.append('(');
            //remember to add 1 to the # of open parenethesis when calling it
            backtrack(n, output, curr, open+1, close);
            //then we delete the one we just appended bc we are BACKTRACKING, so we can get diff answers w/ the current string
            curr.deleteCharAt(curr.length()-1);
        }
        //as long as the # of close parenthesis is less than open
        //we can add a closing parenthesis 
        // (closing has to have a matching pair where the open is first, so close <open is valid)
        if (close < open){
            curr.append(')');
            backtrack(n, output, curr, open, close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
