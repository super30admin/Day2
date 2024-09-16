// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node{
        int key; 
        int val;
        Node next;
    
    public Node(int key,int val){
        this.key=key;
        this.val=val;

    }
}
Node [] nodes;
int buckets;
//initialization of primary array of type nodes to store the pointers to our linkedlist
public MyHashMap(){
    buckets=10000;
    nodes=new Node[buckets];

}
//using function hashcode to find the value of index where we can search position of element
private int hashIndex(int key){
    return Integer.hashCode(key) % buckets;
}
private Node find(Node head,int key){
    Node prev=head;
    Node curr=head;
    while(curr != null && curr.key != key){
        prev=curr;
        curr=curr.next;
    }
    return prev;
}
public void put(int key,int value){
    int index=hashIndex(key);
    //if initially there's no ll present we will create one dummy node at index found by hashIndex function
    if(nodes[index] == null){
        nodes[index]=new Node(-1,-1);
    }
    //if ll is already present at Index position we will call find function and will traverse till end of ll is reached by pointing prev at index
    Node prev=find(nodes[index], key);
    if(prev.next==null){
        prev.next=new Node(key, value);//ll end is reached and node is not found so create a new node at end
    }
    else{
        prev.next.val=value;
    }

}
public int get(int key){
    int index=hashIndex(key);
    if(nodes[index]== null) return -1;
    Node prev= find(nodes[index], key);
    if(prev.next == null){
        return -1;
    }
    else{
        return prev.next.val;
    }
}
public void remove(int key){
    int index=hashIndex(key);
    if(nodes[index]== null) return;
    Node prev=find(nodes[index], key);
    if(prev.next == null) return;
    prev.next=prev.next.next;
}

}
