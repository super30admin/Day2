// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Having doubt about writing time complexity


// Your code here along with comments explaining your approach
//Use two stack called stack and queueStack.
//insert the first push element into queueStack. then insert all other push elements into stack
//whenever pop move all the stack elements into queueStack  when queue stack is empty
//return queueStack last element for peek and pop



class MyQueue {

    var stack: [Int]!
    var queueStack: [Int]!
    
    /** Initialize your data structure here. */
    init() {
        stack = [Int]()
        queueStack = [Int]()
    }
    
    /** Push element x to the back of queue. */
    func push(_ x: Int) {
        if queueStack.isEmpty && stack.isEmpty {
            queueStack.append(x)
        } else {
            stack.append(x)
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    func pop() -> Int {
        if queueStack.isEmpty && stack.isEmpty {
            return -1
        }
        moveStackElementsIntoQueueStack()
        return queueStack.removeLast()
    }
    
    /** Get the front element. */
    func peek() -> Int {
        if queueStack.isEmpty && stack.isEmpty {
            return -1
        }
        moveStackElementsIntoQueueStack()
        return queueStack.last!
    }
    
    /** Returns whether the queue is empty. */
    func empty() -> Bool {
        return queueStack.isEmpty && stack.isEmpty
    }
    
    /** put all stack elements into queueStack */
    func moveStackElementsIntoQueueStack() {
        if stack.isEmpty && queueStack.isEmpty {
            return
        }
         if queueStack.isEmpty {
             while !stack.isEmpty {
                 queueStack.append(stack.removeLast())
             }
          }
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * let obj = MyQueue()
 * obj.push(x)
 * let ret_2: Int = obj.pop()
 * let ret_3: Int = obj.peek()
 * let ret_4: Bool = obj.empty()
 */
