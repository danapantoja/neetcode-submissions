class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        String[] pathArr = path.split("/");
        for (int i =0;i<pathArr.length;i++){
            //ignore empty elements and curr dir elements
            if (pathArr[i].length()!=0 && !pathArr[i].equals(".")){

                if (!stack.isEmpty() && pathArr[i].equals("..")){
                    stack.pop();
                }else if (!pathArr[i].equals("..")){
                    stack.push(pathArr[i]);
                }
                
            }
        }

        //make output list first 
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        //build output
        StringBuilder output = new StringBuilder();
        for (int i =list.size()-1;i>=0;i--){
            output.append('/');
            output.append(list.get(i));
            
        }
        if (output.length()==0) return "/";
        return output.toString();

    }
}