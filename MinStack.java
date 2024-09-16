// Time Complexity : O(1) for getMin(), top(), push(), and O(n) for pop(); O(n) for push() during its worst case
// Space Complexity : O(n) as stack size grows with increase in input, the temporary stack is also used during the worst case of increasing size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MinStack {

    int[] stack;
    static int MAX = 5;
    double min = Double.POSITIVE_INFINITY; // minimum value
    int counter = -1;
    static double CFUpper = 0.5;
    static double CFLower = 0.2;
    static int MF = 2;
    static double c;
    static double m;

    public MinStack() {
        this.stack = new int[MAX];
    }

    public void push(int val) {
        if (val < min)
            min = val;

        c = (double) counter;
        m = (double) MAX;
        if (c / m >= CFUpper) {
            int max = MAX;
            int[] temp = new int[MAX]; // creating a temporary array to store the existing values in array "arr"
            for (int i = 0; i < MAX; i++)
                temp[i] = stack[i];

            MAX = MAX * MF; // increasing the size of the array by multiplicative factor 2
            this.stack = new int[MAX];
            for (int i = 0; i < max; i++)
                stack[i] = temp[i];
            stack[++counter] = val;
        } else
            stack[++counter] = val;

    }

    public void pop() {
        if (stack[counter] == min) {
            min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < counter; i++)
                if (stack[i] < min)
                    min = stack[i];
        }

        c = (double) counter;
        m = (double) MAX;
        if (c / m < CFLower) {
            int[] temp = new int[MAX]; // creating a temporary array to store the existing values in array "arr"
            for (int i = 0; i < MAX; i++)
                temp[i] = stack[i];

            MAX = MAX / MF; // increasing the size of the array by multiplicative factor 2
            this.stack = new int[MAX];
            for (int i = 0; i <= counter; i++)
                stack[i] = temp[i];
        }
        --counter;
    }

    public int top() {
        return stack[counter];
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2

    }

}
