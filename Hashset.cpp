// # Design hashset : ## Problem 2:(https://leetcode.com/problems/design-hashset/
//  # Time complexity: O(N/K) here and N is the number of values; K=1000 
//  # Space complexity:O(K+M) here K =1000 and M is no.of unique values
//  # Did this code successfully run on Leetcode : No 27/28 passed, pls help with the failing test case
//  # Approach: using Seperate Chaining approach The hash value/index is calculated using
//  # key%bucket number and the elements are added, removed and searched. 
 // Any problem you faced while coding this : No 




class MyHashSet {
public:
    /** Initialize your data structure here. */
    
    class Node{
     public:
        
        int value;
        Node *next ;
        Node(int y){
            value =y;
            next =NULL;
        }
       
    };
    
  
    Node* buckets[1000];
    // Node **buckets =new Node*[100];
    
    MyHashSet() {
        for(int i = 0; i < 1000; ++ i)
            buckets[i] = NULL;
    }
    
    void add(int key) {
        int hashindex= key % 1000;
        if( buckets[hashindex] == NULL){
            Node* curr = new Node(key );
            buckets[hashindex] = curr;
            return;
        }
        else{
           
            Node* head = buckets[hashindex];
            Node *temp =head;
            
            //was missing this check ->for first node ->so was adding twice earlier
            if(head->value == key){
                return;
            }
            while (temp->next != NULL){
                    if(temp->value == key){
                        return;
                    }
                    temp = temp->next;
            }
            

            temp->next = new Node(key);
                
            }
            
    }

    
    void remove(int key) {
        int hashindex= key % 1000;
        Node* head = buckets[hashindex];
        if( buckets[hashindex] == NULL){
            return;
         }
        
        if(head->value == key){
                buckets[hashindex] = buckets[hashindex]->next;
                return;
        }
        
        Node* curr = buckets[hashindex];
        Node* prev = buckets[hashindex];
        while (curr != NULL){
         if(curr->value == key){
            prev->next = curr->next;
             return;
            }
        prev= curr;
        curr= curr->next;

        }
        
        
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        bool exist = false;
        int hashindex= key % 1000;
        if( buckets[hashindex] == NULL){
            return exist;
         }
        Node* head = buckets[hashindex];
        Node *temp =head;
        while (temp!= NULL){
                if(temp->value == key){
                        exist = true;
                        return exist;
                    }
                temp = temp->next;
        }
        return exist;
              
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */