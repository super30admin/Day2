// Time Complexity : Average case is O(1)
// Space Complexity : O(n) as stack size grows with increase in input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyQueue {
	
	int[] in;
	int[] out;
	int size = 100;
	int inCount = -1;
	int outCount = -1;

    public MyQueue() {
        in = new int[size];
        out = new int[size];
    }
    
    public void push(int x) {
        in[++inCount] = x;
    }
    
    public int pop() {
        
    	if(outCount == -1) {
    		while(inCount != -1) {
    			out[++outCount] = in[inCount--];
    		}
    		return out[outCount--];
    	}else {
    		return out[outCount--];
    	}
    }
    
    public int peek() {
    	if(outCount == -1) {
    		while(inCount != -1) {
    			out[++outCount] = in[inCount--];
    		}
    		return out[outCount];
    	}else {
    		return out[outCount];
    	}
    }
    
    public boolean empty() {
        return inCount == -1 && outCount ==-1;
    }
    
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
