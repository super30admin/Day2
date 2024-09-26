// Time Complexity : 
  //add: O(n) because tmp.contains will iterate throught the entire list
  //remove: O(1)
  //contains: O(n) because tmp.contains will iterate throught the entire list
  
// Space Complexity : O(1) because the size of list is fixed to 1000;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
  List<List<Integer>> list;
  int size = 1000;
  
  public MyHashSet() {
      list = new ArrayList<>();
      for(int i = 0; i < size; i++){
          list.add(null);
      }
  }
  
  public void add(int key) {
      if(list.get(getIndex(key)) != null){      
          List<Integer> tmp = list.get(getIndex(key));
          if(!tmp.contains(key)){
              tmp.add(key);
          }
      }
      else{
          List<Integer> tmp = new ArrayList<>();
          tmp.add(key);
          list.set(getIndex(key), tmp);
      }        
  }
  
  public void remove(int key) {
      List<Integer> tmp = list.get(getIndex(key));
      
      if(tmp != null){    
          tmp.remove(Integer.valueOf(key));
      }
  }
  
  public boolean contains(int key) {
      List<Integer> tmp = list.get(getIndex(key));
      return tmp != null && tmp.contains(key);
  }
  
  public int getIndex(int key){
      return key%size;
  }
}