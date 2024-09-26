//Time Complexity: Depends on the table-size: Hashing takes O(1) but Linked list lookup takes O(n)

//Approach: Assuming number of buckets = 1000, hashing the key to store it into one of the buckets. Each bucket contains a linked
//list to avoid collisions (Linear Chaining)

import java.util.*;

class MyHashSet 
{
    final private int BUCKETS = 1000;
    private List<List<Integer>> bucketList;
    public MyHashSet() {
        bucketList = new ArrayList<>(BUCKETS);
        for(int i = 0; i < BUCKETS; i++)
            bucketList.add(null);
    }
    
    public void add(int value) 
    {
        int bucket = value % BUCKETS;
        List<Integer> nestedList = bucketList.get(bucket);
        if(nestedList == null)
        {
            nestedList = new LinkedList<>();
            nestedList.add(value);
            bucketList.set(bucket, nestedList);
        }
        if(!nestedList.contains(value))
            nestedList.add(value);       
    }
    
    public void remove(int value) 
    {
        int bucket = value % BUCKETS;
        List<Integer> nestedList = bucketList.get(bucket);
        if(nestedList != null)
            nestedList.remove(Integer.valueOf(value));
    }
    
    public boolean contains(int value) 
    {
        int bucket = value % BUCKETS;
        List<Integer> nestedList = bucketList.get(bucket);
        return nestedList != null && nestedList.contains(Integer.valueOf(value));
    }

}
