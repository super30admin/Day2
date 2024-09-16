//Consider size of hash k, we have chosen 769 as this would distribute comparitively evenly
// Time Complexity : O(n/k)
// Space Complexity : O(n+k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//We will create new datastructure called Bucket which would act as linked list chaining
//We will create an array of buckets of size k.
//We will implent the functions add, remove and contains accordingly.
class MyHashSet {
    private Bucket[] buckets;
    private int keyRange;

    public MyHashSet() {
        keyRange = 769;
        buckets = new Bucket[keyRange];
        for(int i = 0; i < keyRange; i++){
            buckets[i] = new Bucket();
        }
    }
    protected int hashVal(int key){
        return (key % keyRange);
    }
    public void add(int key) {
        int hash = hashVal(key);
        buckets[hash].insert(key);
    }

    public void remove(int key) {
        int hash = hashVal(key);
        buckets[hash].delete(key);
    }
    public boolean contains(int key) {
        int hash = hashVal(key);
        return buckets[hash].find(key);
    }
}
class Bucket{
    private LinkedList<Integer> ll;
    public Bucket(){
        ll = new LinkedList<Integer>();
    }
    public void insert(Integer key){
        int index = ll.indexOf(key);
        if(index == -1)
            ll.addFirst(key);
    }
    public void delete(Integer key){
        ll.remove(key);
    }
    public boolean find(Integer key){
        int index = ll.indexOf(key);
        return (index != -1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */