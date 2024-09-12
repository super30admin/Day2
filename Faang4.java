
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes


package leetcode;

class MyHashSet {
    private boolean[][] array;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        array = new boolean[buckets][];
    }
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(array[bucket]==null){
            if(bucket==0){
                array[bucket]=new boolean[bucketItems+1];
            }else{
                array[bucket]= new boolean[bucketItems];
            }
        }
        array[bucket][bucketItem]=true;
    }


    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(array[bucket]==null)return;
        array[bucket][bucketItem]=false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(array[bucket]==null)return false;
        return array[bucket][bucketItem];
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(10000);
        obj.remove(1);
        boolean param_3 = obj.contains(1);
        System.out.println(param_3);
    }
}


