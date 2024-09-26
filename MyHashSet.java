// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// I first used Array list and then did it for arrays.


// Your code here along with comments explaining your approach

class MyHashSet {
    int[] arr; 
    int size;
    public MyHashSet() {
        arr = new int[1000001];
        size=0;
    }
    
    public void add(int key) {
        for(int i=0;i<size;i++){
            if(arr[i]==key)
                return;
        }
        arr[size++]=key;
    }
    
    public void remove(int key) {
        int index=-1;
        for(int i=0;i<size;i++){
            if(arr[i]==key){
                index = i;
            }
        }
        if(index == -1)
            return;
        for(int i=index+1;i<size;i++){
            arr[i-1] = arr[i];
        }
        size--;
    }
    
    public boolean contains(int key) {
        for(int i=0;i<size;i++){
            if(arr[i]==key)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //Leetcode Test case
        MyHashSet obj = new MyHashSet();
        obj.add(10);
        obj.remove(20);
        boolean param_3 = obj.contains(13);
        System.out.println("Key : 13 : "+param_3);
        //Email Test case
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);         
        hashSet.add(2);         
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);          
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);          
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}