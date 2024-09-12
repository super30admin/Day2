/* Code is submitted successfully on Leetcode
Hash Set with hash function and bucket size = 10000. I am currently using list here if we use mao then it will  be faster and space efficient. Currently, the time complexity of searching O(1) but space is O(N*N) because I am doing chaining here */

class MyHashSet {

    /** Initialize your data structure here. */
    ArrayList<ArrayList<Integer>> hashset = new ArrayList<ArrayList<Integer>>(10000);
    public MyHashSet() {
        for(int i=0; i< 10000; i++){
            hashset.add(new ArrayList());
        }
    }
    
    public void add(int key) {
        if(!hashset.get(key % 10000).contains(key)){
            hashset.get(key % 10000).add(key);
            hashset.set(key % 10000,new ArrayList(hashset.get(key % 10000)));   
        }
    }
    
    public void remove(int key) {
        if(hashset.get(key % 10000).contains(key) == true){
            int index =  hashset.get(key % 10000).indexOf(key);
            hashset.get(key % 10000).remove(index);
        }
        else{
            System.out.println("Values not exists");
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hashset.get(key % 10000).contains(key) == true){
                return true;
        }
        return false;

    }

