/*
 Time complexity - O(1) average and O(n) worst case for  get(),put(),remove() methods
 Space complexity - O(n) worst case to store chain of linked list
 */

 /*
Hashmap is a key,value pair so using array of linkedlists to store the values and to avoid collision.
Even if we have duplicate nodes, as we store in linked list -it should be good.
IndexKeyrange is 10^4 here which means an array of 10000 will be created and we use java std method of 
Integer.hashcode() to generate random hashcode.
while adding a linkedlist , adding a dummy node at the start so that it makes it easy instead of having to adjust
head references from array everytime first element is removed.
*/
public class MyHashMap {
    private static class ListNode{
        int key,val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    ListNode[] nodes;
    int indexKeyRange;

    private int getIndex(int key){
        return Integer.hashCode(key) % indexKeyRange;
    }

    public MyHashMap() {
        indexKeyRange = 10000;
        nodes = new ListNode[indexKeyRange];
    }

    private ListNode find(ListNode head,int key){
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        if(nodes[index] == null){
            nodes[index] = new ListNode(-1,-1);
        }
        ListNode prev = find(nodes[index],key);
        if(prev.next == null){
            prev.next = new ListNode(key,value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int index = getIndex(key);
        if(nodes[index] == null){
            return -1;
        }
        ListNode prev = find(nodes[index],key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.val;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        if(nodes[index] == null){
            return;
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
}
