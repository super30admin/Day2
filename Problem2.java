
// This solution is based on direct address table concept; a boolean array is used and whenever we 
//add a key we set boolean array index key position to true
//remove a key means we set boolean array index key position to false
// Space complexity is o(n) Time complexity is o(1) since lookup by index only

// class MyHashSet {
//     boolean arr[];
//     public MyHashSet() {
//         arr = new boolean[1000001];
//     }
    
//     public void add(int key) {
//         arr[key] = true;
//     }
    
//     public void remove(int key) {
//         arr[key] = false;
//     }
    
//     public boolean contains(int key) {
//         return arr[key];
//     }
// }

// This is the chaining implementation of hashset; created an arraylist where each element is a linkedlist
// handles collision as well
// Time complexity of add, remove and contains o(n) 
// Space complexity will be the size of the table 

class MyHashSet {
    //int bucketSize = 1000000;
    int mainListSize = 100;
    List<List<Integer>> mainList;
    public MyHashSet() {
        mainList = new ArrayList<>(mainListSize);
        for(int i=0; i<mainListSize; i++)
        {
            mainList.add(new LinkedList<Integer>());
            
        }
    }
    
    public void add(int key) {
        
        int index = key % mainListSize;
        List<Integer> bucketList = mainList.get(index);
        if (bucketList==null)
        {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            mainList.set(index, list);
        }
        else
        {
            if(!bucketList.contains(key))
            {
                bucketList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key % mainListSize;
        List<Integer> bucketList = mainList.get(index);
        if(bucketList!=null)
        {
            bucketList.remove((Integer)key);
        }
    }
    
    public boolean contains(int key) {
        int index = key % mainListSize;
        List<Integer> bucketList = mainList.get(index);
        return (bucketList!=null && bucketList.contains(key));
}
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */