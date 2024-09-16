// Time complexity O(n)
// Soace complexity O(2n)


class MyQueue {
    var firstStack, secondStack: Stack
    
    init() {
        firstStack = Stack()
        secondStack = Stack()
    }
    
    func push(_ x: Int) {
        firstStack.push(x)
    }
    
    func isSecondStackEmpty() {
        if secondStack.isEmpty() {
            pushFrom(firstStack, secondStack)
        }
    }
    
    func pop() -> Int {
        isSecondStackEmpty()
        let value = secondStack.pop()
        return value
    }
    
    func pushFrom(_ fromStack: Stack,_ toStack: Stack) {
        while fromStack.isEmpty() == false {
                toStack.push(fromStack.pop())
            }
    }
    
    func peek() -> Int {
        isSecondStackEmpty()
        let result = secondStack.peek() ?? 0
        return result
    }
    
    func empty() -> Bool {
        return firstStack.isEmpty() && secondStack.isEmpty()
    }
}

class Stack {
    private var stack:[Int]
    
    init() {
        self.stack = []
    }
    
    func push(_ value: Int) {
        self.stack.insert(value,at:0)
    }
    
    func pop() -> Int {
        return self.stack.removeFirst()
    }
    
    func peek() -> Int? {
        return self.stack.first
    }
   
    func isEmpty() -> Bool {
        return self.stack.isEmpty
    }
    
    func printStack() {
        print(self.stack)
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
