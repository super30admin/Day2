// Time Complexity :o(1)
// Space Complexity :o(n)  n-size of hashset
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {

    /** Initialize your data structure here. */
    List<Integer>[] bucket;
    double loadFactor=0.75;
    int capacity= 100;
    int count=0;
    public MyHashSet() {
        bucket=new LinkedList[capacity];
        
    }
    
    public void add(int key) {
        if (contains(key)) return;
        if(capacity==count){
            count=0;
            capacity*=2;
            List<Integer>[] oldBucket=bucket;
            bucket= new LinkedList[capacity];
            for(int i=0; i<oldBucket.length; i++){
                List<Integer>list= oldBucket[i];
                if(list!=null){
                    for(int val: list){
                        this.add(val);
                    }
                    
                }
            }
        }
        int hash= key%capacity;
        if(bucket[hash]==null){
            bucket[hash]= new LinkedList<>();
        }
        bucket[hash].add(key);
        ++count;
    }
    
    public void remove(int key) {
        int hash = key % capacity;
        List<Integer> list = bucket[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext())
                if(itr.next() == key){
                    itr.remove();
                    --count;
                }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % capacity;
        List<Integer> list = bucket[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext())
                if(itr.next() == key)
                    return true;
        }
        return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */