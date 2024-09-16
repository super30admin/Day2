// Time Complexity : O(1) on average but in the worst case it could be O(n) for put, get, remove 
// Space Complexity : O(n) depending on the number of entries in the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Customized the linked list + array approach from yesterday's class


// Your code here along with comments explaining your approach

class MyHashMap {

    
    /** Initialize your data structure here. */
    private class LinkNode{
	int key;
	int value;

	LinkNode next;

	    LinkNode(int key, int value){
		    this.key = key;
		    this.value = value;
	    }	
    }
    
    LinkNode[] arr = new LinkNode[1000001];
    
    private int getHashCode(int key){
        return Integer.hashCode(key)%arr.length;
    }
    
    private LinkNode findElement(int key){
        int index = getHashCode(key);
        if(arr[index] == null){
            return arr[index] = new LinkNode(-1,-1);
        }
        else{
            LinkNode prev = arr[index];
            while(prev.next != null && prev.next.key != key){
                prev = prev.next;
            }
            return prev;
        }
    }
   
    /** value will always be non-negative. */
    public void put(int key, int value) {
        LinkNode prev = findElement(key);
        if(prev.next == null){
            prev.next = new LinkNode(key,value);
        }
        else{
          prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkNode prev = findElement(key);
        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;
        }
	}
    
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkNode prev = findElement(key);
        if(prev.next != null){
            prev.next = prev.next.next;           
        }
    }
}
