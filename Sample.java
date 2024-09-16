// Time Complexity :
  // adding : O(log(m)) //m - number of nodes in bucket.
  // remove: O(log(m)) //m - number of nodes in bucket.
  // contains: O(log(m)) //m - number of nodes in bucket.
// Space Complexity : O(n) //n - number of total nodes in hashmap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  // not really problems, but with given a idea about range of numbers that will/can
  // be stored in hash set, could have simply made a boolean array of same range
  // as well.
// Your code here along with comments explaining your approach
  //1. create a array of Nodes(buckets). Reachable by hash value(mod of key).
  //2. each entry in array is a root for a binary search tree.Multiple
  //   Nodes can be added to same tree on collision of hash value(mod of key).
  //3. add, remove , search elements from tree in buckets, based on hash value
  //   of key (mod of key).


class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class MyHashSet {

    private Node hashSet[];
    private final static int HASH_RANGE = 1000;


    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new Node[HASH_RANGE];
    }

    private int getHash(int val){
        return val % HASH_RANGE;
    }

//*********** ADD STRT *************
    private Node add(Node root, Node node){
        if(root == null){
            //root null return node to be added as root.
            return node;
        }

        if(node.val == root.val){
            //if equal dont add simply return root.
            return root;
        }
        else if(node.val < root.val){
            //node.val < root.val, check if node can be added to left of root.
            root.left = add(root.left, node);
        }
        else if(node.val > root.val){
            //node.val > root.val, check if node can be added to right of root.
            root.right = add(root.right, node);
        }

        return root;
    }

    public void add(int key) {

        int hash = getHash(key);

        Node node = new Node(key);
        hashSet[hash] = add(hashSet[hash], node);
    }
//*********** ADD END *************

//*********** REMOVE STRT *************
    private Node getNextSmallFromRight(Node node){
        Node cur = node;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur;
    }

    private Node remove(Node root, int key){
        if(root == null)
            return null;

        if(key == root.val){
            //if both child null, return null
            if(root.left == null && root.right == null){
                return null;
            }
            //if both right child null, return left child, next smallest in line.
            else if(root.right == null){
                return root.left;
            }
            else{
                //get next smallest from right,
                //replace current node val.
                //remove smallest child from right subtree.
                Node node = getNextSmallFromRight(root.right);
                root.val = node.val;
                root.right = remove(root.right, node.val);
            }
        }
        else if(key < root.val){
            //key < root.val, check if key can be removed from left of root.
            root.left = remove(root.left, key);
        }
        else if(key > root.val){
            //key > root.val, check if key can be removed from right of root.
            root.right = remove(root.right, key);
        }

        return root;
    }

    public void remove(int key) {
        int hash = getHash(key);
        hashSet[hash] = remove(hashSet[hash], key);
    }

//*********** REMOVE END *************

//*********** CONTAINS STRT *************

    private boolean walkTree(Node node, int key){
        if(node == null)
            return false;

        //greater move right
        if(key > node.val){
            return walkTree(node.right, key);
        }
        //smaller move left
        else if(key < node.val){
            return walkTree(node.left, key);
        }
        //equal return true
        return true;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = getHash(key);
        Node root = hashSet[hash];
        return walkTree(root, key);
    }

//*********** CONTAINS END *************
}
