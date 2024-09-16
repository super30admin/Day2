// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
public:
  struct Node{
        int key,value;
        Node *next;
    Node(int key, int value){
            this->key=key;
            this->value=value;
            this->next=NULL;
        }
    };;
    vector<Node*>nodes;
     int buckets;
    
    int getbucket(int key){
        return key%buckets;
    }
   Node* find(Node *head,int key){
        Node* prev=head;
        Node* curr=head->next;
        while(curr!=NULL&&curr->key!=key){
            prev=curr;
            curr=curr->next;
        }
        return prev;
    }
    /** Initialize your data structure here. */
    MyHashMap() {
        buckets=10000;
        nodes=vector<Node*>(buckets);
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        int index=getbucket(key);
        if(nodes[index]==NULL){
            nodes[index]=new Node(-1,-1);
        }
        Node* prev=find(nodes[index],key);
        if(prev->next==NULL)
        {
            prev->next=new Node(key,value);
            
        }
         prev->next->value=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
         int index=getbucket(key);
        if(nodes[index]==NULL){
            return -1;
        }
        Node* prev=find(nodes[index],key);
        if(prev->next==NULL)return -1;
        return  prev->next->value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
      int index=getbucket(key);
        if(nodes[index]==NULL){
            return;
        }
        Node* prev=find(nodes[index],key);
        if(prev->next==NULL)return ;
         else prev->next=prev->next->next;  
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */