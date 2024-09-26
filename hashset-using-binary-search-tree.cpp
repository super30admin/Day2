// Implementing the array with BST approach discussed in class last time. !!!

// Time Complexity : O( logn ) worst case for adding, removing and contain
// Space Complexity : O( 983 ) for initial array and  O(n) worst case for binary tree 
// Did this code successfully run on Leetcode : YES 
// Any problem you faced while coding this : 
//   Didn't remember removal of node from binary tree, so looked up algo and then wrote.


// Your code here along with comments explaining your approach

class BST {
   public:  
   int data;
   BST * left;
   BST * right;
   BST(){}
   BST( int data ) {
       this->data = data;
       this->left = nullptr;
       this->right = nullptr;
   } 
   BST* newnode(){
       BST* root =  new BST( -1 ); // -1 is not part of the key
       return root;
   }   
   BST* createnode(  BST* ptr, int val ){
       ptr = new BST( val );
       return ptr;
   } 
};

class MyHashSet {    
    // initialization of the array 
    // choosing a large prime number less than million for the array so less collisions probablility
    BST* temp = new BST();
    BST* arr[ 983 ];

public:
    MyHashSet() {
        // initializing a bst at each of the array element
        for ( int i=0; i<983; i++ ){
            arr[i] = temp->newnode();
        }
    }
    
    int calchash( int key ){
        return ( key % 983 );
    }
    
    BST* insertBST( BST*root, int data ) {
       if( root == nullptr ){
           return temp->createnode( root, data );
       }
       if ( data < root->data ){
           root->left = insertBST( root->left, data );
       }  else {
           root->right = insertBST( root->right, data );
       }
       return root;
    }
    
    
    BST* inordersucc( BST* temp ){
        while( temp->left != nullptr ){
            temp = temp->left;
        }
        return temp;
    }
 
    BST* removeBST( BST*root, int data ){  
       // 3 cases
       // node has no children, remove the node
       //. node has one child, copy the node to the parent , delete child
       //  node has 2 children,   find inorder successor, copy it to node and delete inorder successor
        if( root == nullptr ){
            return root;
        }
        
        if( data == root->data ){ 
            if( root->left == nullptr && root->right == nullptr ){
                delete root;
                root = nullptr;
                return root;
            } else if ( root->left == nullptr && root->right != nullptr ){
                BST* temp = root->right;
                delete root;
                root = nullptr;
                return temp; 
            } else if ( root->left != nullptr && root->right == nullptr ){
                BST* temp = root->left;
                delete root;
                root = nullptr;
                return temp;
            } else { // 2 children case
                BST* inorder = inordersucc( root->right );
                root->data = inorder->data;
                root->right = removeBST( root->right, inorder->data );
            }
        } else if( data < root->data ){
            root->left = removeBST( root->left, data );
        } else {
            root->right = removeBST( root->right, data );
        }
        return root;
    }
    
    bool containsElemBST( BST*root, int data ){
       if( root == nullptr ){
           return false;
       }
       if( data == root->data ){
           return true;
       }  else if ( data < root->data ){
           return containsElemBST( root->left, data );
       }  else {
           return containsElemBST( root->right, data );
       }
    }
    
    void add(int key) {
        int index = calchash( key );
        if( arr[index]->data == -1) {
            // case when root has no elem 
            arr[index]->data = key;
        } else {
            // go search in bst where to add and add there the key
            BST* root = arr[index];
            if( !containsElemBST( root, key )){ // hash set has unique values
                insertBST( root, key );
            }
        }

    }
    
    void remove(int key) {
       int index = calchash( key );
       if( arr[index]->data == -1) {
          return; // node not present
       } else {
           // go search in bst where to delete and delete it 
           BST* root = arr[index];
           // handle the case when only one element present and deleting it causes root to be null
           if( root->data == key && root->left == nullptr && root->right == nullptr ){
               delete root;
               arr[index] = temp->newnode();  // create a new root there;
               return;
           }
           arr[index] = removeBST( root, key );    
       }
    }
    
    bool contains(int key) {
        int index = calchash( key );
        if( arr[index]->data == -1) {
            return false;
        } else {
            // go search in bst
            BST* root = arr[index];
            return containsElemBST( root, key );
        }
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
