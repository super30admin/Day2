//time complexity is o(n)
//space complexity iso(n)
//passed leetcode
//using the approach discussed in class, i.e. two dimensional array

class MyHashSet {
    boolean[][] hasstore;
    int oneways = 1000;
    int twoways = 1000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hasstore = new boolean[oneways][];


    }
    private int hashone(int key){
        return key%oneways;
    }
    private int hashtwo(int key){
        return key/twoways;
    }

    public void add(int key){
        int oneway = hashone(key);
        int twoway = hashtwo(key);
        if(hasstore[oneway] == null){
            hasstore[oneway] = new boolean[twoways];
        }
        hasstore[oneway][twoway] = true;
    }

    public void remove(int key) {
        int oneway = hashone(key);
        int twoway = hashtwo(key);
        if(hasstore[oneway] != null){


            hasstore[oneway][twoway] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int oneway = hashone(key);
        int twoway = hashtwo(key);

        return (hasstore[oneway]!= null && hasstore[oneway][twoway]);
    }




}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */