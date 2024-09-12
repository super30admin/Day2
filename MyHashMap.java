// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : Not able to return the value to which the specified key is mapped in get() function.


// Your code here along with comments explaining your approach
class MyHashMap {

    HashMap<Integer, Integer> hash;
    public MyHashMap() {
        hash = new HashMap<>();
    }

    public void put(int key, int value) {
        hash.put(key,value);

        if(hash.containsKey(key)){
            hash.replace(key,value);
        }

    }

    public int get(int key){
        if(hash == null){
            return -1;
        }
        for (Map.Entry<Integer, Integer> e : hash.entrySet()){
            if(hash.containsKey(key)){
                e.getValue();

            }
        }
        return -1;
    }





    public void remove(int key) {
        if(hash.containsKey(key))
        {
            hash.remove(key);
        }
    }
}
