class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            if(!minStack.isEmpty()) {
                if(val == minStack.peek()) {
                    minStack.pop();
                }
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

//Learned: Stack.peek() means look at the top value, but do not return.
//Learned: We create instance variables at the top and then we create objects of those instance variables when we create an object of the main method. Now methods can access those instances.
//Learned: <= makes a difference because when we pop the top value we pop minStack as well. And if there are consecutive values of the same minValue then we need to pop them all accordingly.
