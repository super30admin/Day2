import java.util.Stack;

public class HashmapDesign {
    private int min; // Variable to store the current minimum value
    private Stack<Integer> st; // Stack to store all the elements

    // Constructor to initialize the stack and set the initial minimum value
    public HashmapDesign() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    // Method to push a value onto the stack
    public void push(int val) {
        // If the value being pushed is less than or equal to the current minimum,
        // push the current minimum onto the stack and update the minimum
        if (val <= min) {
            st.push(min);
            min = val;
        }
        // Push the value onto the stack
        st.push(val);
    }
    
    // Method to pop a value from the stack
    public void pop() {
        // Pop the value from the stack
        int val = st.pop();
        // If the popped value is the current minimum,
        // pop the next value from the stack and set it as the new minimum
        if (val == min) {
            min = st.pop();
        }
    }
    
    // Method to get the value at the top of the stack
    public int top() {
        return st.peek();
    }
    
    // Method to get the current minimum value
    public int getMin() {
        return min;
    }

    // Main method to test the MinStack implementation
    public static void main(String[] args) {
        HashmapDesign obj = new HashmapDesign();
        obj.push(3);
        obj.push(5);
        System.out.println(obj.getMin()); 
        obj.push(2);
        obj.push(1);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin()); 
        System.out.println(obj.top());    
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
