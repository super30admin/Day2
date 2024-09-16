package Day2;

import java.util.HashMap;
class HashSetCustom {

    HashMap<Integer, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public HashSetCustom() {

    }

    public void add(int key) {
        map.put(key,1);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }

    public static void main(String args[]){
        HashSetCustom ob = new HashSetCustom();

        ob.add(2);
        ob.add(4);
        ob.add(6);

        System.out.println(ob.contains(2));

        ob.remove(2);

        System.out.println(ob.contains(2));

    }
}

