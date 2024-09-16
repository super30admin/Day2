#include <iostream>

using namespace std;

#define MAX 1000

class Stack {
    int top;

public:
    int a[MAX]; // Maximum size of Stack

    Stack() {
        top = -1;
     }

    void push(int x);
    int pop();
    //int peek();
    bool isEmpty();

};

void Stack::push(int x) //push function
{
    if(top == MAX-1){
        cout << " Error: Stack overflow" << endl;  //stack overflow
    }

      a[++top] = x;
}

int Stack::pop()  // pop function
{
    if (top == -1){
        cout << "Error: No element to pop" << endl; //stack underflow
    }

    return top--;
}


bool Stack::isEmpty() //empty function
{
    //Your code here
    if (top == -1) return 1;
    return 0;

}

//Queue class implementation
class Queue{
public:
 Stack S1, S2;

void enqueue(int x);

int dequeue();
};

void Queue::enqueue(int x) //enqueue function
{
    S1.push(x);
    cout<<"Element inserted in queue" << endl;
}

int Queue::dequeue()  //dequeue function
{
    int x,y;
    while(!S1.isEmpty())
      {
        //take element from 1st stack and insert it into 2nd stack
        x = S1.pop();
        S2.push(x);
      }

    y = S2.pop();   // to remove element

    while(!S2.isEmpty())
    {
        //moving back the elements from the 2nd stack to the 1st Stack
        x = S2.pop();
        S1.push(x);
    }

}
// Driver program to test above functions
int main()
{
    class Queue q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    cout << q.dequeue() << " Removed element from Queue\n";


    return 0;
}
