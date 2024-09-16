/*
Time complexity
O(n) get for accessing the last element in the bucket of the linked list
O(1) for appending to the linked list in the bucket
O(n) for removing the element in the bucket of the linekd list
Space Complexity
O(n^2) for the bucket with linked list cosidering inbuilt linked lists grow double at a load factor of 80%
*/
import java.util.*;
class MyHashMap {
	ArrayList<LinkedList<int []>> a;
    public MyHashMap() 
	{
    a=new ArrayList<LinkedList<int []>>(2000);
    for(int i=0;i<2000;i++) {
    	a.add(i,new LinkedList<int []>());
    }
    }
    
    public void put(int key, int value) {

        	int index=key%2000;
        	var z=a.get(index);
        	int hit=0;
        	for( var i:z) {
        		
        		if(i[0]==key) {
        			i[0]=key;
        			i[1]=value;
        			z.set(z.indexOf(i), i);
        			hit=1;
        		}
        	}
        	if(hit==0) {
        		z.add(new int[] {key,value});
        		a.set(index, z);
        	}
        	
        
    }
    
    public int get(int key) {
    	int index=key%2000;
    	var z=a.get(index);
    	int hit=0;
    	
    	for( var i:z) {
    		
    		if(i[0]==key) {
    			hit=1;
    			return i[1];
    		}
    	}
    	if(hit==0) {
    		return -1;
    	}
    	return 0;
    }
    
    public void remove(int key) {
    	int index=key%2000;
    	var z=a.get(index);
    	int hit=0;
    	outer: for( var i:z) {
    		
    		if(i[0]==key) {
    			hit=1;
    			z.remove(i);
    			break outer;
    		}
    	}
    	if(hit==0) {
    		System.out.println("No key present with the given input");
    	}
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */