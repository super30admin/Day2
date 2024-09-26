package design2;

import java.util.LinkedList;

/*          Time Complexity: if N is number of values we insert and K is predefined array length
                                in worst case we have to scan entire array so O(K/N)

            Space Complexity: if O(K+V) where K is predefined array length and
                                          V is number of values we inserted into array

            Code successfully ran on leetcode, no problems faced. 


*
*
* */

class MyHashSet {

    /** Initialize your data structure here. */

    private Bucket[] hashArray;
    private int maxKeyRange;
    public MyHashSet() {
        maxKeyRange = 769;
        hashArray = new Bucket[maxKeyRange];
        for(int i=0; i<maxKeyRange; i++){
            hashArray[i] = new Bucket();
        }
    }

    public void add(int key) {
        int index = hashFunction(key);
        hashArray[index].insert(key);
    }

    public void remove(int key) {
        int index = hashFunction(key);
        hashArray[index].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashFunction(key);
        return hashArray[index].exists(key);
    }

    private int hashFunction(int key){
        return (key % maxKeyRange);
    }

}

class Bucket{
    private LinkedList<Integer> linkedList;
    public Bucket(){
        linkedList = new LinkedList<Integer>();
    }

    public void insert(Integer key){
        int index = linkedList.indexOf(key);
        if(index == -1)
            linkedList.addFirst(key);
    }

    public void delete(Integer key){
        linkedList.remove(key);
    }

    public boolean exists(Integer key){
        int index = linkedList.indexOf(key);
        if(index == -1)
            return false;
        else
            return true;
    }
}
