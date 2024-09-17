class MyHashSet {

    /** Initialize your data structure here. */
    Bucket[] bucket;
    int initialSize;
    public MyHashSet() {
        this.initialSize = 771;
        bucket = new Bucket[this.initialSize];
        for(int i=0; i<this.initialSize; i++)
        {
            bucket[i] = new Bucket();
        }
    }

    private int hashFunc(int input)
    {
        return input % this.initialSize;
    }

    public void add(int key) {
        int place = this.hashFunc(key);
        if(!this.bucket[place].exists(key))
            this.bucket[place].insert(key);
    }

    public void remove(int key) {
        int place = this.hashFunc(key);
        if(this.bucket[place].exists(key))
            this.bucket[place].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int place = this.hashFunc(key);
        return this.bucket[place].exists(key);
    }
}

class Bucket{
    LinkedList<Integer> list;
    public Bucket()
    {
        list = new LinkedList<>();
    }
    public void insert(Integer val)
    {
        int index = this.list.indexOf(val);
        if(index==-1)
            this.list.addFirst(val);
        else
            this.list.add(val);
    }
    public boolean exists(Integer val)
    {
        int index = this.list.indexOf(val);
        return index!=-1;
    }
    public void remove(Integer val)
    {
        int index = this.list.indexOf(val);
        if(index!=-1)
            this.list.remove(index);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */