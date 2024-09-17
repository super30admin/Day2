// Time Complexity : O(1)
// Space Complexity : O(1000*1000)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class hashset {
    private boolean[][] storage;
    int buckets;
    int bucketitems;

    public hashset(){
        buckets = 1000;
        bucketitems = 1000;
        storage = new boolean[buckets][];
    }

    private int hash1(int key){
              return key%100;
    }

    private int hash2(int key){
        return key/100;
    }

    public void add(int key){
        int bucketloc = hash1(key);
        int bucketnum = hash2(key);
        
        if(storage[bucketloc] == null){
            if (bucketloc == 0){
                storage[bucketloc] = new boolean[1000+1];
            }
            else{
                storage[bucketloc] = new boolean[1000];
            }
        }

        storage[bucketloc][bucketnum] = true;
    }

    public void remove(int key){
        int bucketloc = hash1(key);
        int bucketnum = hash2(key);
        if( storage[bucketloc] == null) 
               return;
        if (storage[bucketloc][bucketnum] == false)
               return;
        else 
             storage[bucketloc][bucketnum] = false;

    }

    public boolean contanis(int key){
        int bucketloc = hash1(key);
        int bucketnum = hash2(key);
        if(storage[bucketloc] == null) return false;
        return storage[bucketloc][bucketnum];
    }


}

/**

* Your HashSet object will be instantiated and called as such:

* hashSet obj = new hashSet();

* obj.add(key);

* obj.remove(key);

* boolean param_3 = obj.contains(key);

*/
