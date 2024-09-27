import java.util.LinkedList;
/*
 * Creating a class Bucket consisting of a LinkedList 
 * Using LinkedList as to ADD and Delete an element from head of linkedlist
 * is O(1) complexity 
 * 
 * Creating an array of this bucket class and using a modula function to find
 *  a index in the array at which we need to add the element 
 *  
 *  N= Number of possible key values
 *  K= number of predefined buckets
 *  M= All possible unique indexes
 * Time Complexity :O(N/K)
 * 
 * Space Complexity:O(K+M)
 * 
 * 
 * */

public class MyHashSet {

	Bucket[] bucketarray;
	int keyrange;
    /** Initialize your data structure here. */
    public MyHashSet() {
    	 keyrange=769;
        bucketarray= new Bucket[this.keyrange];
       
        for(int i=0;i<this.keyrange;++i) {
        	this.bucketarray[i]= new Bucket();
        }
        
    }
    public int hashkey(int key) {
    	return (key%this.keyrange);
    }
    
    public void add(int key) {
        
    	int index = hashkey(key);
    	this.bucketarray[index].insert(key);
    }
    
    public void remove(int key) {
        int index= hashkey(key);
        this.bucketarray[index].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index= hashkey(key);
		return this.bucketarray[index].exists(key);
        
    }
    
    public static void main(String args[]) {
    	MyHashSet set =new MyHashSet();
    	
    	set.add(1);
    	set.add(2);
    	set.add(3);
    	set.add(4);
    	set.add(4);
    	
    	System.out.println(set.contains(1));
    }
}

class Bucket{
	LinkedList<Integer> list ;

	public Bucket() {
		
		this.list = new LinkedList<Integer>();
	}
	
	public void insert(int key) {
		int index= list.indexOf(key);
		if(index==-1)
			this.list.addFirst(key);
	}
	
	public boolean exists(int key) {
		int index= list.indexOf(key);
		return	(index!=-1);
			
	}
	
	public void remove(int key) {
		
		list.remove(key);
	}
	
}