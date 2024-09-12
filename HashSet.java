/* 1. Program implements a hashset that performs the function of add, remove and checking if a particular key exists or not.
2. The key is not added directlt, rather boolean status is added/removed.
3. 2-D array is used to implement the same which uses bucketNumber to identify column and bucketItemNumber to identify row. */



class MyHashSet{
    boolean[1000][] hashset;

    public MyHashSet(){
        hashset = new boolean[1000][];
    }

    public void add(int key){
        int bucketNumber = bucket(key);
        int bucketItemNumber = bucketItem(key);
        if(hashset[bucketNumber] == null){
            hashset[bucketNumber] = new boolean[1000];
        }
        hashset[bucketNumber][bucketItemNumber] = true;
    }

    public void remove(int key){
        int bucketNumber = bucket(key);
        int bucketItemNumber = bucketItem(key);
        if(hashset[bucketNumber] != null){
            if(hashset[bucketNumber][bucketItemNumber] == true){
                hashset[bucketNumber][bucketItemNumber] = false;
            }
        }
    }

    public boolean contains(int key){
        int bucketNumber = bucket(key);
        int bucketItemNumber = bucketItem(key);

        return hashset[bucketNumber] != null && hashset[bucketNumber][bucketItemNumber] == true;

    }

    public int bucket(int key){
        return key % 1000;
    }

    public int bucketItem(int key){
        return key / 1000;
    }

    
}