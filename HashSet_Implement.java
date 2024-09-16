package HashSet_Implement;

public class HashSet_Implement {
	static class MyHashSet {

	    int buckets = 1001;
	        int bucket_Items = 1001;
	        boolean[][] storage = new boolean[buckets][];
	        
	        private int bucket(int key)
	        {
	            return key%buckets;
	        }
	        
	        private int bucket_Item(int key)
	        {
	            return key/bucket_Items;
	        }
	        
	    public MyHashSet() {
	        
	        
	        
	    }
	    
	    public void add(int key) {
	        int bucket = bucket(key);
	        int bucket_item = bucket_Item(key);
	          if(storage[bucket]==null)
	          {
	              storage[bucket] = new boolean[bucket_Items];
	          }
	        
	           storage[bucket][bucket_item]=true;
	        
	        
	    }
	    
	    public void remove(int key) {
	        int bucket = bucket(key);
	        int bucket_item = bucket_Item(key);
	          if(storage[bucket]!=null)
	          {
	              storage[bucket][bucket_item]=false;
	          }
	        
	           
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	        int bucket = bucket(key);
	        int bucket_item = bucket_Item(key);
	          if(storage[bucket]!=null)
	          {
	            return storage[bucket][bucket_item];
	          }
	        else
	            return false;
	        
	    }
	}

	

	public static void main(String[] args) {
		MyHashSet set_obj = new MyHashSet();
		set_obj.add(24);
		set_obj.add(41);
		set_obj.add(67);
		set_obj.remove(24);
		System.out.println(set_obj.contains(41));
		System.out.println(set_obj.contains(40));
		
		
		
		
		// TODO Auto-generated method stub

	}

}
