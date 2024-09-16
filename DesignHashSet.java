//Time Complexity -
  //1. add - O(1)
  //2. remove - O(1)
  //3. contains - O(1)

//Space Complexity - O(N)

class DesignHashSet{
  private boolean[][] storage;
  private int buckets;
  private int bucketItems;

  public DesignHashSet(){
    storage = new boolean[1000][];
    buckets = 1000;
    bucketItems = 1000;
  }

  public void add(int key){
    int bucketIndex = storageBucketIndex(key);
    int bucketItemsIndex = storageBucketItemsIndex(key);

    if(storage[bucketIndex] == null){
      if(bucketIndex == 0){
        storage[bucketIndex] = new boolean[bucketItems + 1];
      }else{
        storage[bucketIndex] = new boolean[bucketItems];
      }
    }

    storage[bucketIndex][bucketItemsIndex] = true;
  }

  public void remove(int key){
    int bucketIndex = storageBucketIndex(key);
    int bucketItemsIndex = storageBucketItemsIndex(key);

    if(storage[bucketIndex] == null)
      return;

    storage[bucketIndex][bucketItemsIndex] = false;
  }

  public boolean contains(int key){
    int bucketIndex = storageBucketIndex(key);
    int bucketItemsIndex = storageBucketItemsIndex(key);

    if(storage[bucketIndex] == null)
      return false;

    return storage[bucketIndex][bucketItemsIndex];
  }

  private int storageBucketIndex(int key){
    return key % buckets;
  }

  private int storageBucketItemsIndex(int key){
    return key / bucketItems;
  }
}
