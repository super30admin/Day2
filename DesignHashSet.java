import java.util.*;
import java.io.*;

class MyHashSet {
  private Bucket[] bucketArray;
  private int keyRange;

  /** Initialize your data structure here. */
  public MyHashSet() {
    this.keyRange = 53;
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
  
  public static void main(String[] args) {
	  MyHashSet ob = new MyHashSet();
	  ob.add(0);
	  ob.add(14);
	  ob.add(8);
	  System.out.println("Does the hashset contain 8? "+ob.contains(8));
	  ob.remove(8);
	  System.out.println("Does the hashset contain 8? "+ob.contains(8));
  }
}


class Bucket {
  private LinkedList<Integer> container;

  public Bucket() {
    container = new LinkedList<Integer>();
  }

  //inserting elements into the linked list
  public void insert(Integer key) {
    int index = this.container.indexOf(key);
    if (index == -1) {
      this.container.addFirst(key);
    }
  }

  //delete elements in that particular linked list
  public void delete(Integer key) {
    this.container.remove(key);
  }

  public boolean exists(Integer key) {
    int index = this.container.indexOf(key);
    return (index != -1);
  }
}


//Time complexity is O(N/K) where N is the number of all possible values and K is the number of buckets
//Space complexity is O(N+M) M is the number of values inserted into the hashset which are unique