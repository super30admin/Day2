import java.util.Arrays;

class MyHashSet {

	int a[]=new int[1000];
	int i=-1;
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        i++;
        if(!contains(key))
        a[i]=key;
    }
    
    public void remove(int key) {
    	int index=0;
        for(int i=0;i<a.length;i++)
        {
        	if(a[i]==key)
        	{
        index=i;
        	}
        }
        for (int i = index; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	 for(int i=0;i<a.length;i++)
         {
         	if(a[i]==key)
         	{
         return true;
         	}
         }
    	 return false;
    }
    
    public static void main(String args[])
    {
    	MyHashSet hashSet = new MyHashSet();
    	hashSet.add(1);         
    	hashSet.add(2);         
    	System.out.println("contains"+hashSet.contains(1));    // returns true
    	System.out.println("conatins"+hashSet.contains(3));    // returns false (not found)
    	hashSet.add(2);          
    	System.out.println("contains"+hashSet.contains(2));    // returns true
    	hashSet.remove(2);          
    	System.out.println("contains"+hashSet.contains(2));    // returns false (already removed)
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */