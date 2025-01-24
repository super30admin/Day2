/**
 * Using inverted arrays to track the stack and its correspinding values.
 */

class MyQueue {

    private Integer[] input;
    private Integer[] output;
    int inputSize;
    int outputSize;
    int n = 1000;

    public MyQueue() {
        input = new Integer[n];
        output = new Integer[n];
        inputSize = 0;
        outputSize = 0;
    }
    
    public void push(int x) {
        input[inputSize] = x;
        inputSize++;
    }
    
    public int pop() {
        int val = peek();
        output[outputSize] = null;
        outputSize--;
        return val;
    }
    
    public int peek() {
          if(outputSize == 0){
           while(inputSize > 0){
            output[inputSize] = input[outputSize];
            input[outputSize] = null;
             outputSize++;
             inputSize--;
           }
        }
      return output[outputSize];
    }
    
    public boolean empty() {
        return outputSize == 0 && inputSize == 0;
    }
}
