class MinStack {

    private int minNum = Integer.MAX_VALUE;
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> subStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (minNum >= val) {
            minNum = val;
            subStack.push(val);
        }
        mainStack.push(val);
    }
    
    public void pop() {
        int val = mainStack.pop();
        if (val == minNum) {
            subStack.pop();
            minNum = subStack.isEmpty() ? Integer.MAX_VALUE : subStack.peek();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minNum;
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