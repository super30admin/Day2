// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

/*For a given key value, first we apply the hash function to generate a hash key, which corresponds to the address in our main storage. With this hash key, we would find the bucket where the value should be stored.

Now that we found the bucket, we simply iterate through the bucket to check if the desired <key, value> pair does exist.*/
class MyHashMap {

	    private int len = 1000;
	  //creating a new linked list 
	    private Node[] buckets= new Node[len];
	    
	  //Creating the Node class to store key and value
	  //key and value are the attributes of Node which is similar to hashmap key and value
	    private class Node{
	        Node next;
	        int key;
	        int val;
	        Node(int key, int val){
	            this.key = key;
	            this.val=val;
	            
	        }
	        
	    }
	   //creating our base hash function -, we could adopt the modulo operator as the hash function, since the key value is of integer type
	    private int hash(int key){
	        return key%len;
	    }
	    
	    
	    public MyHashMap() {
	        
	    }
	    
	    public void put(int key, int value) {
	    	
	        int index = hash(key);
	        Node temp = buckets[index];
	        //create a new node if there is no existing bucket
	        if (temp == null){
	            buckets[index] = new Node(key, value);
	            return;
	        }
	        Node prev = temp;
	        while (temp != null){
	            if (temp.key == key){
	                temp.val = value;
	                return;
	            }
	            prev = temp;
	            temp = temp.next;
	        }
	        prev.next = new Node(key,value);
	    }
	    
	    
	    public int get(int key) {
	         int index = hash(key);
	        Node temp = buckets[index];
	        while (temp != null ){
	            if (temp.key == key){
	                return temp.val;
	            }
	            temp = temp.next;
	        }
	        return -1;
	    }
	    
	    public void remove(int key) {
	           int index = hash(key);
	        Node temp = buckets[index];
	        if (temp == null){
	            return;
	        }
	        if (temp.key == key){
	            buckets[index] = buckets[index].next;
	        }
	        while (temp.next != null ){
	            if (temp.next.key == key){
	                temp.next = temp.next.next;
	                return;
	            }
	            temp = temp.next;
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

