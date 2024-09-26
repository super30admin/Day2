// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class MyQueue {

    /** Initialize your data structure here. */
    var firstStack :  [Int]
    var secondStack : [Int]
    init() {
         firstStack = [Int]()
         secondStack = [Int]()
    }
    
    /** Push element x to the back of queue. */
    func push(_ x: Int) {
        firstStack.append(x)
    }
    
    /** Removes the element from in front of queue and returns that element. */
    func pop() -> Int {
        var poppedElement: Int
        for i in (0..<firstStack.count).reversed() {
            secondStack.append(firstStack[i])
            firstStack.remove(at: i)
            }
        
        poppedElement = secondStack.removeLast()
        for i in (0..<secondStack.count).reversed() {
            firstStack.append(secondStack[i])
            secondStack.remove(at: i)
            }
        return poppedElement
        
    }
    
    /** Get the front element. */
    func peek() -> Int {
        var poppedElement: Int
        for i in (0..<firstStack.count).reversed() {
            secondStack.append(firstStack[i])
            firstStack.remove(at: i)
            }
        
        poppedElement = secondStack.last!
        
        for i in (0..<secondStack.count).reversed() {
            firstStack.append(secondStack[i])
            secondStack.remove(at: i)
            }

        return poppedElement 
    }
    
    /** Returns whether the queue is empty. */
    func empty() -> Bool {
        return firstStack.isEmpty
    }
}


