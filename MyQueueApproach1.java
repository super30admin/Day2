import java.util.ArrayList;


/*          Approach 1:
                Overall Time Complexity: O(n)
*               Overall Space Complexity: O(n)

                Code successfully ran on leetcode, no problems faced.
* */

public class MyQueueApproach1 {
    private ArrayList<Integer> stack1, stack2;

    public MyQueueApproach1() {
        stack1 = new ArrayList<Integer>();
        stack2 = new ArrayList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        /*          Time Complexity:O(1)
        *           Space Complexity: O(n) for storing queue elements
        * */
        stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        /*          Time Complexity:O(n)
         *           Space Complexity: O(n)
         * */

        while(stack1.size() > 1){
            stack2.add(stack1.remove(stack1.size()-1));
        }
        int poppedElement = stack1.remove(stack1.size() -1);
        while(stack2.size() > 0)
            stack1.add(stack2.remove(stack2.size()-1));
        return poppedElement;
    }

    /** Get the front element. */
    public int peek() {

        /*          Time Complexity:O(n)
         *           Space Complexity: O(n)
         * */

        while(stack1.size() > 1){
            stack2.add(stack1.remove(stack1.size()-1));
        }
        int poppedElement = stack1.get(stack1.size() -1);
        while(stack2.size() > 0)
            stack1.add(stack2.remove(stack2.size()-1));
        return poppedElement;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        /*          Time Complexity:O(1)
         *           Space Complexity: O(1)
         * */

        return stack1.isEmpty();
    }

    public static void main(String args[]){
        MyQueueApproach1 obj = new MyQueueApproach1();
        obj.push(1);
        System.out.println(obj.pop());
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}


class MyQueueApproach2 {

    /** Initialize your data structure here. */

    private ArrayList<Integer> stack1, stack2;
    public int peek;

    public MyQueueApproach2() {
        stack1 = new ArrayList<Integer>();
        stack2 = new ArrayList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        /*          Time Complexity:O(1)
         *           Space Complexity: O(n) for storing queue elements
         * */

        stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /*          Amortized Time Complexity:O(1)
                    WorstCase: O(n)
         *           Space Complexity: O(1) for storing queue elements
         * */

        if(stack2.size() == 0){
            while(stack1.size() > 0){
                stack2.add(stack1.remove(stack1.size()-1));
            }
        }
        return stack2.remove(stack2.size() -1);
    }

    /** Get the front element. */
    public int peek() {
        /*          Time Complexity:O(1)
         *           Space Complexity: O(1) for storing queue elements
         * */

        if(!stack2.isEmpty()){
            return stack2.get(stack2.size() -1);
        }
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}