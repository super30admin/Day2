import java.util.Stack;

// Time Complexity : O(1) ??
// Space Complexity : O(1) ??
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Took Hint to figure out the logic part


// Your code here along with comments explaining your approach
public class Design2_2 {
    /** Initialize your data structure here. */
    public Design2_2() {
        
    }
    
     class LinkedListNode{
        int key;
        LinkedListNode next;
        LinkedListNode(int key){
            this.key = key;
        }
    }
    
    
    LinkedListNode[] nodeArray = new LinkedListNode[1000];
    
    public void add(int key) {
        int index = key % nodeArray.length;
        
        if(nodeArray[index]==null){
            nodeArray[index] = new LinkedListNode(key);
        }else{
            LinkedListNode curr = nodeArray[index];
            
            while(curr.next!=null && curr.key!=key){
                curr=curr.next;
            }
            if(curr.key!=key){
                curr.next =new LinkedListNode(key);
            }

        }

    }
    
    public void remove(int key) {
        int index = key % nodeArray.length;
        
        if(nodeArray[index]==null){
            return;
        }
        
         if(nodeArray[index].key==key){
            nodeArray[index] = nodeArray[index].next;
             return;
        }
        
        LinkedListNode curr=nodeArray[index];
        LinkedListNode previous = null;
        while(curr.next!=null && curr.key!=key ){
            previous=curr;
            curr=curr.next;
        }
        if(curr.key == key){
            if(previous!= null){
                previous.next=curr.next;
            }
            else
                nodeArray[index]=null;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % nodeArray.length;
        
        if(nodeArray[index]==null){
            return false;
        }
        
        LinkedListNode curr = nodeArray[index];
            
            while(curr!=null){               
                if(curr.key==key){
                    return true;
                }
                curr = curr.next;
            }
             
        return false;
    }
}
