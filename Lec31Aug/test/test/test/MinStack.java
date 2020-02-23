class MinStack {

    /** initialize your data structure here. */
    Stack<Integer>  st  ;
    int  min = Integer.MAX_VALUE;
    public MinStack() {
            st =  new  Stack<>()         
            min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(st.size()<=0){
            min=x;
           sr.add( x);return;
        }   
        
        if(x>st.peek()){
            st.push(x) ;
        }else{
            st.push( x+x - min);
            min =  x ;            
        }
    }
    
    public void pop() {
        if(min > st.peek()){
            int actualValue = min;
            int recoveredValue = 2*min - st.peek();
            min = recoveredValue;
        }
        int t = st.peek();
    }
    
    public int top() {
        if(min < st.peek()){
            return min;
        }
        return   st.peek();
    }
    
    public int getMin() {
        return  min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */