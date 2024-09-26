//Time complexity O(1)
//Space complexity is O(N)
//Successfully run in the leetcode

class MyHashSet {
    int MAX=1000001;
     boolean [] arr;
     public MyHashSet() {
           arr = new boolean[MAX];
     }
     
     public void add(int key) {
         arr[key]=true;
         return;
     }
     
     public void remove(int key) {
         arr[key]=false;
         return;
     }
     
     public boolean contains(int key) {
         return arr[key];
     }
 }
 
 /**
  * Your MyHashSet object will be instantiated and called as such:
  * MyHashSet obj = new MyHashSet();
  * obj.add(key);
  * obj.remove(key);
  * boolean param_3 = obj.contains(key);
  */// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
