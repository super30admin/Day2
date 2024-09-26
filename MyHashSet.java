import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {

    private final int array_size = 100;;
    private List<List<Integer>> parentList;
    /** Initialize your data structure here. */
    public MyHashSet() {
        
        parentList = new ArrayList(array_size);
        for(int i=0;i<array_size;i++){
            parentList.add(null);
        }
    }
    
    public void add(int key) {
        int index = key % array_size;
        List<Integer> childlist = parentList.get(index);
        if(childlist==null){
            List<Integer> childList = new LinkedList<>();
            childList.add(key);
            parentList.set(index,childList);
        }else{
            if(!childlist.contains(key)){
                childlist.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        if(childList!=null && childList.contains(key)){
            childList.remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        return childList!=null && childList.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
