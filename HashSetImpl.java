// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :No
package com.s30.day2;
//Implementation if HashSet by double hashing.To deal with 1000000 elements, Created an array of size 1000 and sub array of size 1000.
//while adding elements, we will set the value as true.While removing elements, we will set as false.
public class HashSetImpl {
	int buckets=1000;
	int bucketList=1000;
	boolean[][] storage=new boolean[1000][];
	private int firstHash(int key){
		return key%buckets;
	}
	private int secondHash(int key){
		return key/buckets;
	}
	public HashSetImpl() {
	}
	//
	public void add(int key){
		int bucket=firstHash(key);
		int bucketItem=secondHash(key);
		if (storage[bucket]==null){
			storage[bucket]=new boolean[bucketList];
		}
		storage[bucket][bucketItem]=true;
	}
	
	public void remove(int key){
		int bucket=firstHash(key);
		int bucketItem=secondHash(key);
		if (storage[bucket]!=null){
			storage[bucket][bucketItem]=false;
		}
	}
		
	public boolean contains(int key){
		int bucket=firstHash(key);
		int bucketItem=secondHash(key);
		if (storage[bucket]!=null){
			return storage[bucket][bucketItem];
		}
		else{
			return false;
		}
		
	}
	
	public static void main(String args[]){
		HashSetImpl obj = new HashSetImpl();
		obj.add(1);         
		obj.add(2);         
		obj.contains(1);    // returns true
		obj.contains(3);    // returns false (not found)
		obj.add(2);          
		obj.contains(2);    // returns true
		obj.remove(2);          
		obj.contains(2);    // returns false (already removed)
	}
	}
	

