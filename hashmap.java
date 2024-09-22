// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by creating primarybuckets and then creating secondary buckets if needed
 */
class MyHashMap {
    int primarybucket;
    int secondarybucket;
    int[][] storage;

    public MyHashMap() {
        this.primarybucket = 1000;
        this.secondarybucket = 1001;
        this.storage = new int[primarybucket][];
    }

    public int getprimaryhash(int key)
    {
        return key % primarybucket;
    }
    
    public int getsecondaryhash(int key)
    {
        return key / secondarybucket;
    }

    public void put(int key, int value) {
        int primaryhash = getprimaryhash(key);

        if(storage[primaryhash] == null)
        {
            storage[primaryhash] = new int[secondarybucket];
            Arrays.fill(storage[primaryhash], -1);
        }
        int secondaryhash = getsecondaryhash(key);
        storage[primaryhash][secondaryhash] = value;
        
    }
    
    public int get(int key) {
        int primaryhash = getprimaryhash(key);
        int secondaryhash = getsecondaryhash(key);
        if(storage[primaryhash] == null)
        {
            return -1;
        }
        return storage[primaryhash][secondaryhash];
    }
    
    public void remove(int key) {
        int primaryhash = getprimaryhash(key);
        int secondaryhash = getsecondaryhash(key);
        if(storage[primaryhash] == null)return;
        storage[primaryhash][secondaryhash] = -1;
    }
}
