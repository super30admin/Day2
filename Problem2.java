public class Problem2 
{
    /** Initialize your data structure here. */
    int bucket;
    int bucketItems;
    boolean[][] set;
    public Problem2() 
    {
        bucket = 1000;
        bucketItems = 1000;
        set = new boolean[bucket][bucketItems];
    }
    
    private int hash(int key)
    {
        return key % 1000;
    }
    
    private int hashItems(int key)
    {
        return key / 1000;
    }
    
    public void add(int key) 
    {
        int bucketHash = hash(key);
        int bucketItemsHash = hashItems(key);
        if(set[bucketHash] == null)
        {
            if(bucketHash == 0)
            {
                set[bucketHash] = new boolean[bucketItemsHash + 1];
            }
            else
                 set[bucketHash] = new boolean[bucketItemsHash];  
        }
         set[bucketHash][bucketItemsHash] = true;
        
            
    }
    
    public void remove(int key) 
    {
        int bucketHash = hash(key);
        int bucketItemsHash = hashItems(key);
        if(set[bucketHash] == null)
        {
            return;
        }
        
         set[bucketHash][bucketItemsHash] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) 
    {
        int bucketHash = hash(key);
        int bucketItemsHash = hashItems(key);
        if(set[bucketHash][bucketItemsHash])
            return true;
        return false;
    } 
}
 
