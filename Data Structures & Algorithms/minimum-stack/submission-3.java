class MinStack {

    //two stacks, one that is the main
    //and min stack gets the min at that current index (kinda like dp)
    List<Integer> min;
    List<Integer> arr;

    public MinStack() {
        arr = new ArrayList<>();
        min  = new ArrayList<>();
    
    }
    public void push(int val) {
        //if the min stack is empty, we just add it to min stack 
        if (min.isEmpty()){
            min.add(val);
            
        }else{
            //we still add to the min, but if the min doesnt change
            //we add the previous min again
             min.add(Math.min(val, min.get(min.size() - 1)));
        }
        //add the value to the main stack
        arr.add(val);

    }
    
    public void pop() {
        //remove the top of the stacks for BOTH
        min.remove(min.size()-1);
        arr.remove(arr.size()-1);
        
    }
    
    //return the top of the main stack
    public int top() {
        return arr.get(arr.size()-1);
    }
    
    //gets the top of the min stack (current minimum)
    public int getMin() {
        return min.get(min.size()-1);
    }
}
