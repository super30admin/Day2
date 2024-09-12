// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Similar to HashMap
class MyHashSet {
    
	// Array containing heads for linkedlists per index
    ListNode[] hashset = new ListNode[100000];

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
	// hash function
    private int hashFunction(int val){
        return Integer.hashCode(val) % hashset.length;
    }
    
	// returns prev of actual node if found,  null if not
    private ListNode findElement(int index, int val){
        if(hashset[index] == null){
            hashset[index] = new ListNode(-1);
            return hashset[index];
        } else {
            ListNode curr = hashset[index];
            while(curr.next != null && curr.next.val!= val){
                curr= curr.next;
            }
            
            return curr;
        }
        
    }
	
	// finds element is present. If present, doen't to anything , else adds
    public void add(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next == null){
            prev.next = new ListNode(key);
        }
    }
    
	// finds element is present. If present,removes , else nothing
    public void remove(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next == null){
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next != null){
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */