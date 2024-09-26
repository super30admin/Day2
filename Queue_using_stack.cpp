//Time Complexity:push-O(1), pop-O(N), peek-O(1) empty - O(N)
//Space complexity:push-O(N), pop-(N), peek-o(1), empty-O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
#include <iostream>
#include <stack>

using namespace std;

class MyQueue {
    /** Initialize your data structure here. */
private:
    stack<int> queue;
    stack<int> temp;
    int top; //to store top or front element of queue
public:
    MyQueue() {
        top = 0;
    }

    /** Push element x to the back of queue. */
    void push(int x) {
        if (queue.empty())
            top = x;      //store the first inserted elemnt as top
        queue.push(x);
    }

    /** Removes the element from in front of queue and returns that element.
        pop elements from queue and store them in temp. The top element of temp is popped and returned.
        The elements are pushed back from temp to queue
    */

    int pop() {
        int popelement = 0;
        if (queue.empty())
            return popelement;
        while (!queue.empty()) {
            temp.push(queue.top());
            queue.pop();
        }
        popelement = temp.top();
        temp.pop();
        if (temp.empty()) {
            top = 0;
        }
        while (!temp.empty()) {
            push(temp.top());
            temp.pop();
        }
        return popelement;
    }

    /** Get the front element. */
    int peek() {
        return top;
    }

    /** Returns whether the queue is empty. */
    bool empty() {
        return queue.empty();
    }
};


int main()
{
    MyQueue* queue = new MyQueue();

    queue->push(1);
    queue->push(2);
    cout<<queue->peek()<<endl;  // returns 1
    cout << queue->pop() << endl;   // returns 1
    cout << queue->empty() << endl; // returns false
    return 0;
};
