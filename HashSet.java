// Time Complexity :all the operation will take O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//We can use double hashing and create a 2d boolean array.
//we can use our hashing formulas to find out the index at which the key will be placed.
class MyHashSet {

   int firstBucket;
	int secondBucket;
	boolean[][] arr;

	public int getFirstBucket(int value) {
		return (value % firstBucket);
	}

	public int getSecondBucket(int value) {
		return (value / secondBucket);
	}

	public MyHashSet() {
		firstBucket = 1000;//it will give error if we don't make it 1000.
		secondBucket = 1000;
		arr = new boolean[firstBucket][];
	}

	public void add(int key) {
		if (arr[getFirstBucket(key)] == null) {
			arr[getFirstBucket(key)] = new boolean[secondBucket];
			
		} 
			arr[getFirstBucket(key)][getSecondBucket(key)] = true;
		
	}

	public void remove(int key) {
		if (arr[getFirstBucket(key)] != null) {
			arr[getFirstBucket(key)][getSecondBucket(key)] = false;
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		if (arr[getFirstBucket(key)] != null) {
			return (arr[getFirstBucket(key)][getSecondBucket(key)]);
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
 
 //below is the broot force approach.
 
 class MyHashSet {
    class Node{
        int val;
        Node next;
        Node(int k){
            this.val=k;
            this.next=null;
        }
    }
    Node head;

    /** Initialize your data structure here. */
    public MyHashSet() {
        head=new Node(-1);
        head.next=null;
        
    }
    
    public void add(int key) {
        if(contains(key)){
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            if(temp.val==key){
                return;
            }
            temp=temp.next;
        }
        temp.next=new Node(key);
    }
    
    public void remove(int key) {
        if(!contains(key)){
            return;
        }
        Node temp=head;
        while(temp.next.val!=key){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        Node temp=head;
        while(temp!=null){
            if(temp.val==key){
                return true;
            }
            temp=temp.next;
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