class MinStack {

    Stack<StackClass> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        StackClass st;
        if(stack.isEmpty()){
            st = new StackClass(val, val);
        }else{
            StackClass last = stack.peek();
            int lastVal = last.minimum;
            st = new StackClass(val, Math.min(lastVal, val));
        }
        stack.push(st);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().minimum;
    }
}

class StackClass{
    int value;
    int minimum;

    public StackClass(int value, int minimum){
        this.value = value;
        this.minimum = minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */