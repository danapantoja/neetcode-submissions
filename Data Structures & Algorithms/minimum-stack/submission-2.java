class MinStack {
    List<Integer> min;
    List<Integer> arr;

    public MinStack() {
        arr = new ArrayList<>();
        min  = new ArrayList<>();
        

    }
    public void push(int val) {
        
        if (min.isEmpty()){
            min.add(val);
            
        }else{
             min.add(Math.min(val, min.get(min.size() - 1)));
        }
        arr.add(val);

    }
    
    public void pop() {
        min.remove(min.size()-1);
        arr.remove(arr.size()-1);
        
    }
    
    public int top() {
        return arr.get(arr.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
    }
}
