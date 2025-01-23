// Time Complexity : O(N/K) - Assuming the elements are evenly distributed, the size of the bucket is N/K.
// In the worst case, we will need to scan the entire bucket
// Space Complexity : O(K+N) - K is the number of predefined buckets , N is the no of elements to be inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Given a value, first we generate a key for this value via the hash function
The generated key serves as the index to locate the bucket
Once the bucket is located, we perform insert,delete,contains
 */

class Pair<U, V> {
    U first;
    V second;

    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    LinkedList<Pair<Integer, Integer>> bucketList;

    Bucket() {
        this.bucketList = new LinkedList<>();
    }

    public void put(Integer key,Integer value){
        boolean found=false;
        for(Pair<Integer,Integer> p: this.bucketList){
            if(p.first.equals(key)){
                p.second=value;
                found=true;
            }
        }
        if(!found){
            this.bucketList.add(new Pair<Integer, Integer>(key,value));
        }
    }

    public Integer get(Integer key){
        for(Pair<Integer,Integer> p: this.bucketList){
            if(p.first.equals(key)){
                return p.second;
            }
        }
        return -1;
    }

    public void remove(Integer key){
        for(Pair<Integer,Integer> p: this.bucketList){
            if(p.first.equals(key)){
                this.bucketList.remove(p);
                break;
            }
        }
    }

}

class MyHashMap {
    List<Bucket> array;
    int size;

    public MyHashMap() {
        this.size=1000;
        this.array=new LinkedList<>();
        for(int i=0;i<this.size;i++){
            this.array.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hash=key%size;
        this.array.get(hash).put(key,value);
    }

    public int get(int key) {
        int hash=key%size;
        return this.array.get(hash).get(key);
    }

    public void remove(int key) {
        int hash=key%size;
        this.array.get(hash).remove(key);
    }
}
