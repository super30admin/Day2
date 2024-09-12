// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    
    private class ListNode {
        int key;
        ListNode next;
        public ListNode(int key) {
            this.key = key;
        }
    }
    
    private ListNode[] hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new ListNode[10000];
    }
    
    public int hashFunc(int key) {
        return key % hashSet.length;
    }
    
    public ListNode findElem(int key, int index) {
        if (hashSet[index] == null) {
            hashSet[index] = new ListNode(-1);
            return hashSet[index];
        } else {
            ListNode prev = hashSet[index];
            while (prev.next != null && prev.next.key != key)
                prev = prev.next;
            return prev;
        }
    }
    
    public void add(int key) {
        int index = hashFunc(key);
        ListNode prev = findElem(key, index);
        if (prev.next == null)
            prev.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int index = hashFunc(key);
        ListNode prev = findElem(key, index);
        if (prev.next != null)
            prev.next = prev.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashFunc(key);
        ListNode prev = findElem(key, index);
        if (prev.next == null)
            return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */