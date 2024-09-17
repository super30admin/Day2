class Bucket{
	private LinkedList<Integer> container;

  public Bucket() {
    container = new LinkedList<Integer>();
  }

  public void insert(Integer key) {
    int index = this.container.indexOf(key);
    if (index == -1) {
      this.container.addFirst(key);
    }
  }

  public void delete(Integer key) {
    this.container.remove(key);
  }

  public boolean exists(Integer key) {
    int index = this.container.indexOf(key);
    return (index != -1);
  }
}

class MyHashSet {
    
    private Bucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i)
            this.bucketArray[i] = new Bucket();
        }
    
    protected int _hash(int key) {
        return (key % this.keyRange);
    }
    
    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
     }
    
    public void remove(int key) {
        int bucketIndex = this._hash(key);
    this.bucketArray[bucketIndex].delete(key);
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
        
    }
}

// Time Complexity : O(N), where N is the number of keys
// Space Complexity : O(K + M), where K is the no. of buckets, M is the no. of values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed the leetcode solution to understand how to design hashmap.


// Your code here along with comments explaining your approach