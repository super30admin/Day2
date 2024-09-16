class MyHashSet {

    int MAX_SIZE = 1000;
    Double LOAD_FACTOR = 0.70;
    int count =0;
    List<Integer>[] container = null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        container = new LinkedList[MAX_SIZE];
    }

    public void add(int key) {
       if((LOAD_FACTOR * MAX_SIZE) == count){
           rehash();
       }
        int index = hashCode(key);

        if(container[index] == null){
            container[index] = new LinkedList<>();
        }
        if(!contains(key)){
              container[index].add(key);
              count++;
        }
    }

    public void rehash(){
          count =0;
          MAX_SIZE *=2;
          List<Integer>[] old = container;
          container = new LinkedList[MAX_SIZE];
          for(List<Integer> bucket : old){
              if(bucket != null){
                  for(int i=0; i<bucket.size(); i++){
                      add(bucket.get(i));
                  }
              }
          }
    }

    public int hashCode(int key){
        return key % MAX_SIZE;
    }

    public void remove(int key) {
        int index = hashCode(key);
        if(contains(key)){
            container[index].remove((Integer)key);
            count--;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashCode(key);
         if(container[index] == null){
            return false ;
        }
        return container[index].contains(key);
    }
    /*
           Time Complexity - O(n/k) - n elements and k - no of buckets
           Space Complexity - O(n+k) - n elements and k - no of buckets
    */
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */