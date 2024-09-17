// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyQueue {
    stack<int>in;
    stack<int>out;
public:
    MyQueue() {
        
    }
    
    //o(1)
    void push(int x) {
        in.push(x);
    }
    
    //o(n)
    int pop() {
        if(out.empty()) {
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
            
        } 
        int top = out.top();
        out.pop();
       return top;
    }
    
    //o(n)
    int peek() {
         if(out.empty()) {
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
        } 
       return out.top();   
    }
    
    //o(1)
    bool empty() {
        return in.empty() && out.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */

class MyHashMap {
    
    
public:
      struct Node{
        int key,value;
        Node*next;
          
          Node(int key,int value){
              this->key = key;
              this->value = value;
             this->next = NULL;
          }
    
    };
     int bucket = 10000;
     Node* node[10000];
    
    MyHashMap() { 
         for (int i=0;i<bucket;++i)
            node[i] = NULL;
    }
    
    Node* find(Node* head,int key) {
        Node *pre = head;
        Node *curr = head->next;
        
        while(curr != NULL && curr->key != key){
            pre = curr;
            curr = curr->next;
        }
        
        return pre;
    }
    
    int getHash(int key) {
        return key%bucket;
    }
    
    void put(int key, int value) {
        int index = getHash(key);
        
        if(node[index] == NULL) {
            node[index] = new Node(-1,-1);
        } 
        Node *prev = find(node[index],key);
        
        if(prev->next == NULL) {
            prev->next = new Node(key,value);
        } else {
            prev->next->value = value;
        }
        
    }
    
    int get(int key) {
        int index = getHash(key);
        if(node[index] == NULL) {
            return -1;
        }
        Node *prev = find(node[index],key);
        if(prev->next == NULL) {
            return -1;
        } else {
           return prev->next->value;
        }
    }
    
    void remove(int key) {
         int index = getHash(key);
        if(node[index] == NULL) {
            return;
        }
        
        Node *prev = find(node[index],key);
        if(prev->next == NULL) {
            return;
        } else {
          prev->next = prev->next->next;
        }
        
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */