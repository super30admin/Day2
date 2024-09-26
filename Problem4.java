// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Design a hash map

class MyHashMap {
    
      LinkedList<Entry>[] map;
    int SIZE=769; //prime number to reduce chances of collision

    public MyHashMap() {
        map=new LinkedList[SIZE];
        
    }
    
    public void put(int key, int value) {
        
         int bucket=key%SIZE;
        if(map[bucket]==null){
            map[bucket]=new LinkedList<Entry>();
            map[bucket].add(new Entry(key,value));
        }else{
            
            for (Entry entry: map[bucket]){
                
                if(entry.key==key)return;
            }
        }
        map[bucket].add(new Entry(key,value));
        
    }
    
    public int get(int key) {
        
        int bucket=key%SIZE;
        LinkedList<Entry> entries=map[bucket];
        if (entries==null) return -1;
        for (Entry entry:entries){
            if(entry.key==key) return key;
        }
        return -1;
         }
        
    
    public void remove(int key) {
        int bucket = key % SIZE;
			Entry toRemove = null;
			if(map[bucket] == null) return;
			else {
				for(Entry entry : map[bucket]){
					if(entry.key == key) {
						toRemove = entry;
					}
				}
				if(toRemove == null) return;
				map[bucket].remove(toRemove);
			}
    }}
class Entry{
        int key;
        int val;
        
        Entry(int key, int val){
            this.key=key;
            this.val=val;
        
    }
}
