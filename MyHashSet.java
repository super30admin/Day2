// Time Complexity : insert avg O(1), remove O(1), contains O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : a little deciding the structure
//             and execution but ran successfully 26/32 test cases on Leetcode

class MyHashSet {

    internalArray[] hashSet;

    public MyHashSet() {
        this.hashSet = new internalArray[1000];

    }

    public void add(int key) {
        if(this.contains(key)) return;

        int first = this.firstHash(key);
        int second = this.secondHash(key);

        if(this.hashSet[first] == null){
        	this.hashSet[first] = new internalArray();
        }

        if(this.hashSet[first].size < key)
        {
          this.hashSet[first].resize(key + 1);
        }

        this.hashSet[first].array[second] = key;

    }

    public void remove(int key) {
        if(!this.contains(key)) return;

        int first = this.firstHash(key);
        int second = this.secondHash(key);

        this.hashSet[first].array[second] = -1;

    }

    public boolean contains(int key) {

        int first = this.firstHash(key);
        int second = this.secondHash(key);

        if(this.hashSet[first] != null) {
        	return this.hashSet[first].array[second] == key;
        }


        return false;
    }

    private int firstHash(int key){
        return key % 1000;
    }

    private int secondHash(int key){
        return key / 1000;
    }

}


class internalArray{
     int size;
    int[] array;

    public internalArray(){
        size = 100;
        array = new int[100];
    }

    public void resize(int len){
        int[] newArray = new int[len];

        for(int i = 0; i< this.size; i++){
            newArray[i] = this.array[i];
        }

        this.array = newArray;
        this.size = len;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
