/*
The average time complexity of add, put and remove is O(1).

Here, we use both arrays and linkedlist to solve the problem. First the index of the key is found. Then we use traverse through the linked
list if any to perform the operations.

Yes, the solution was run of leetcode.
 */
class MyHashSet {
    Node arr[];
    int size;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new Node[100000];
        size = 100000;
    }

    public void add(int key) {
        int index = key%size;
        Node root = arr[index];
        if(root==null){
            arr[index] = new Node(key);
        }
        else{
            Node prev = null;
            while(root!=null){
                if(root.key == key){return;}
                prev = root;
                root = root.next;
            }
            prev.next = new Node(key);
        }
    }

    public void remove(int key) {
        int index = key%size;
        Node root = arr[index];
        if(root==null){
            return;
        }
        else{
            Node prev = null;
            while(root!=null){
                if(root.key==key){
                    if(prev==null){
                        arr[index] = root.next;
                        return;
                    }
                    else{
                        prev.next = root.next;
                        return;
                    }
                }
                prev = root;root = root.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%size;
        Node root = arr[index];
        if(root==null){
            return false;
        }
        else{
            while(root!=null){
                if(root.key==key){
                    return true;
                }
                root = root.next;
            }

            return false;
        }
    }
}

class Node{
    int key;
    Node next;

    Node(int key){
        this.key = key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */