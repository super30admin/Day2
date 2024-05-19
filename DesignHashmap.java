// Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    int[] primArr;

    public MyHashMap() {
        this.primArr = new int[1000001];
    }
    
    public void put(int key, int value) {
        primArr[key] = value + 1;
    }
    
    public int get(int key) {
        return primArr[key] - 1;
    }
    
    public void remove(int key) {
        primArr[key] = 0;
    }
}
