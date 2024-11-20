class MyHashMap {
     class Node{
         int key;
         int value;
         Node next;
         
         Node(int key, int val){
             this.key = key;
             this.value = val;
         }
     }
    
    Node[] hashMap;
    
    public MyHashMap() {
        hashMap = new Node[10000];
    }
    public int index(int key){
        return (Integer.hashCode(key))%hashMap.length;
    }
    
    public Node find(int key){
        //Get the index
        int hashKey = index(key);
        
        if(hashMap[hashKey] == null){
            
            return hashMap[hashKey] = new Node(-1,-1);
        }
    
        Node prev = hashMap[hashKey];
         
        while(prev.next != null && prev.next.key != key){ 
            prev = prev.next;
        }
        
      return prev;
    }
    
    public void put(int key, int value) {
       int ind =  index(key);
       Node prevNode = find(key);
        
        //key exist
        if(prevNode.next == null){
            prevNode.next = new Node(key,value);
            
        }
        else{ //key does not exist
           prevNode.next.value = value;
        }
    }
    
    public int get(int key) {
       int ind =  index(key);
       Node prevNode = find(key);
        
        //exists
        if(prevNode.next != null){
            return prevNode.next.value;
        } 
        else{  //not exists
            return -1;
        }
        
    }
    
    public void remove(int key) {
        int ind =  index(key);
       Node prevNode = find(key);
       
        if(prevNode.next != null){
            prevNode.next = prevNode.next.next; 
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */