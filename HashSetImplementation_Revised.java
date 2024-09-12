class MyHashSet {
    int bucket=100;
    int bucketItem=1000;
    Boolean[] []hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
      hashSet=new Boolean[bucket][];

    }
    int hashFunc1(int key)
    {
        return key%bucket;
    }
    int hashFunc2(int key)
    {
        return key/bucketItem;
    }
    public void add(int key) {
        int index1=hashFunc1(key);
        int index2=hashFunc2(key);
        if(hashSet[index1]==null)
        {
            hashSet[index1]=new Boolean[bucketItem];
        }
        hashSet[index1][index2]=true;
    }
    
    public void remove(int key) {
        int index1=hashFunc1(key);
        int index2=hashFunc2(key);
        if(hashSet[index1]==null )
        {
            return;
        }
        hashSet[index1][index2]=false;

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1=hashFunc1(key);
        int index2=hashFunc2(key);
        if(hashSet[index1]!=null)
        {
           return hashSet[index1][index2];  
        }
        return false;
    }
}
//Time Complexity-O(1)
//Space Complexity-O(n)
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */