/*
 *              Implement queue using stacks

 https://leetcode.com/problems/implement-queue-using-stacks/description/

 * Time Complexity : push-> O(n); top, pop, empty-> O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * Your code here along with comments explaining your approach :
 *              - Keeping two stacks; one primary and second one to reverse the contents
 *                of primary stacks and enqueue it back again to primary stack.
*/
#include<iostream>
#include<stack>

using namespace std;

class myQueue{
    public:
        stack<int> stk;
        stack<int> queue;

    public:
        void push(int value) {
            while(!stk.empty()) {
                queue.push(stk.top());
                stk.pop();
            }
            stk.push(value);
            while(!queue.empty()){
                stk.push(queue.top());
                queue.pop();
            }
        }

        int pop() {
            // Deleting entries only from the primary stack
            int current = 0;
            current = stk.top();
            stk.pop(); // In C++, pop function doesn't return the popped value.

            return current;
        }

        int top() {
            int peek = 0;
            peek = stk.top();
            return peek;
        }

        bool isEmpty() {
            return stk.empty();
        }

        void display() {
            stack<int> display = stk;
            cout << "first->"; 
            while(!display.empty()) {
                cout << display.top() << "->";
                display.pop();
            }
            cout << "last\n";
        }
};

int main() {
    myQueue* queue = new myQueue();

    queue->push(3);
    queue->push(6);
    queue->push(9);
    queue->push(12);
    queue->push(15);

    cout << "\nCurrent stack : " << endl;
    queue->display();

    queue->pop();
    cout << "\n\nAfter popping one element : " << endl;
    queue->display();

    queue->pop();
    cout << "\n\nAfter popping two elements : " << endl;
    queue->display();

    return 0;
}
/*
 * Output of the program :
 
    Current stack : 
    front->3->6->9->12->15->tail


    After popping one element : 
    front->6->9->12->15->tail


    After popping two elements : 
    front->9->12->15->tail
*/