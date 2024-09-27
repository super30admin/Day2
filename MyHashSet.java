import java.util.LinkedList;

class MyHashSet {

    // DEsiging hashset we have taken here linkedlist. With help of hashing function will get index within the range of buckets.
    // we will first check if it containes the key if not then will check the index of that key if not assigned.
    // If its assigned will add at the last of current key or create new LinkedList and assign it to given key.
    // to remove element will find the key's index and and will remove that index from the list.
    // to check if key is present we use containes method from linkedlist.

    int buckets = 1000000;
    
     LinkedList<Integer>[] list;

    public MyHashSet() {
        this.list = new LinkedList[buckets];;
    }
    
    public int getIndex(final int key){
        return Integer.hashCode(key) % buckets;
    }
    public void add(final int key) {
        
        final int i = getIndex(key);
        if(contains(key) == false){
    
    if( list[i] == null ){
         final LinkedList<Integer>  newL = new LinkedList<>();
        newL.add(key);
        list[i] = newL;
            
    }else{
        final LinkedList<Integer> l1 = list[i];
        l1.addLast(key);
    }
}
     
    }
    
    public void remove(final int key) {
         final int i = getIndex(key);
        if(list[i]==null) return;    
        if(list[i].indexOf(key) != -1){
           list[i].remove(list[i].indexOf(key));    
        }
      
        
    }
    
    public boolean contains(final int key) {
         final int i = getIndex(key);
       if(list[i] == null) return false;
        
        return list[i].contains(key);
    }
}
