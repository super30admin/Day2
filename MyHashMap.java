//time complexity: O(1)  //worst case we might to traverse a link list if lot collision then o(N)
//space complexity : O(N)
//Leetcode: Yes.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 */
/*
 * Create a class as we need to store the combination of key and value pair
 */
class Pair<x,y> {
    x key;
    y value;

    Pair(x key,  y value) {
        key = key;
        value = value;
    }
}

class HashStore {
    //Need a Linklist to store elements (list is need if there is collision, single value placeholder will not work)
    List<Pair<Integer, Integer>> store;

    HashStore() {
        store = new LinkedList<Pair<Integer, Integer>>();
    }

    void add(Integer key, Integer value) {
        boolean present = false;
        for (Pair <Integer, Integer> p: store) {
            if (p.key.equals(key)) {
                //if already present just update the with the new value
                present = true;
                p.value = value;
          //      break;
            }
        }
        //if not found then just add to hash store which is a list and can carry multiple elements (if there is collision)
        if (!present) {
           // Pair<Integer, Integer> p = new Pair<Integer, Integer>(key, value);
            store.add(new Pair<Integer, Integer>(key, value));
        }
    }

    Integer get(int key) {
        for (Pair<Integer, Integer> p: store) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }

        return -1;
    }

    public void remove(int key){
        for (Pair<Integer, Integer> p: store) {
            if (p.key.equals(key)) {
                store.remove(key);
                break;
            }
        }
    }
}
class MyHashMap {
    //mod value and size of my array (randomly chosen)
    int hash_value = 769;
    List <HashStore> hashTable;
    public MyHashMap() {
        hashTable = new ArrayList<HashStore>(hash_value);
        for (int i = 0; i < hash_value; i++) {
            //allcoate memory for the link list at each index.
            hashTable.add(new HashStore());
        }
    }

    public void put(Integer key, Integer value) {
        int array_position = key % hash_value;

        hashTable.get(array_position).add(key, value);
    }

    public Integer get(Integer key) {
        int array_position = key % hash_value;
        if (hashTable.contains(array_position)) {
            return hashTable.get(array_position).get(key);
        }
        return -1;
    }

    public void remove(Integer key) {
        int array_position = key % hash_value;
        if (hashTable.contains(array_position)) {
            hashTable.get(array_position).remove(key);
        }
    }

    public static void main(String args[]) {

         MyHashMap obj = new MyHashMap();
         obj.put(10,20);
         obj.put(4567,90000);
         obj.put(198,786);
         Integer param_2 = obj.get(10);
         obj.remove(10);

    }
}
