//Time Complexity : Worst case(O(K)) where K is the base size of HashSet, where all the elements of same hash value are added to the set. Best Case O(1)


//Space Complexity : O(K + N) here K is the base size of HashSet and N is the number of elements added to the hashSet


//Implementing HashSet by creating an array of Linkedlist of size 1000( since 10^6 can be maximum size of Hashset, defining array of (max_size)^0.5)

//We calculate the Hash value of the key and add key to the LinkedList at the Array Index of HashValue 
class MyHashSet {
    
    LinkedList[] hashSet;
    Integer baseSize = 1000;

    public MyHashSet() {
        hashSet = new LinkedList[baseSize];
    }
    
    public void add(int key) {
        //We check if the Hashset contains the key, if it doesnt then we add to the HashSet
        if(!contains(key)){
            //We create or get the Linkedlist at the index given by Hash function and key value to linkedList
            if(hashSet[hash(key)] == null){
                    LinkedList<Integer> temp = new LinkedList();
                    temp.add(key);
                    hashSet[hash(key)] = temp;
                } else {
                    hashSet[hash(key)].add(key);
            }   
        }
        
    }
    
    public void remove(int key) {
        //We check if the Hashset contains the key, if it does then we remove from the HashSet
         if(contains(key)){
            LinkedList<Integer> temp = hashSet[hash(key)];
            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i) == key) {
                    temp.remove(i);
                    break;
                }
            }
         }   
    }
    
    public boolean contains(int key) {
        //checking if Hashset contains the key
        if(hashSet[hash(key)] != null){
            LinkedList<Integer> temp = hashSet[hash(key)];
            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i) == key) return true;
            }
            return false;   
         } else return false;
    }
    
    //helper function to basically locate the index to which keys can be added
    public int hash(int key){
        return key % baseSize;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
