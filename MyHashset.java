// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class MyHashSet {
    int size = 1000000;
    LinkedList<Integer>[] userlist;

    private int get_index(int key) { // Getting the index for the key
        return key % size;
    }

    public MyHashSet() {
        userlist = new LinkedList[size];
    }

    public void add(int key) {
        int i = get_index(key);
        if (userlist[i] == null) {
            userlist[i] = new LinkedList<>();
        }
        if (userlist[i].indexOf(key) == -1)// adding the key because it's not present in the list
        {
            userlist[i].add(key);
        }
    }

    public void remove(int key) {
        int i = get_index(key);
        if (userlist[i] == null) {
            return;
        }
        if (userlist[i].indexOf(key) != -1) // removing the key because it is present in the list
        {
            userlist[i].remove(userlist[i].indexOf(key));
        }
    }

    public boolean contains(int key) {
        int i = get_index(key);
        // if the key is not present in the list returns false
        if (userlist[i] == null || userlist[i].indexOf(key) == -1) {
            return false;
        }
        //if the key is present in the list returns true
        return true;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
