public class Hashmap {
 
    
    class MyHashMap {
        class Node{
            int val;
            int key;
            Node next;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        private Node [] storage;
    
        public MyHashMap() {
            this.storage = new Node[10000];
        }
    
        private int hashIdx(int key){
            return key%10000;
        }
    
         public Node find(Node head, int key){
                Node curr = head;
                Node prev = null;
    
                while(curr != null && curr.key != key){
                    prev = curr;
                    curr = curr.next;
                }
    
               return prev;
    
        }
        
          public void put(int key, int value) {
    
                int hash = hashIdx(key);
                if(storage[hash] == null){
                    storage[hash] = new Node(-1,-1);
                }
    
                Node prev = find(storage[hash],key);
                if(prev.next == null){
                    prev.next = new Node(key,value);
                }else{
                    prev.next.val = value;
                }
            System.out.println(prev.next.val + "   " + prev.next.key);
        }
        
       
        public int get(int key) {
            
             int hash = hashIdx(key);
            if(storage[hash] == null) return -1; 
            Node prev = find(storage[hash],key);
             if(prev.next == null){
                    return -1;
             }
            else{
                  return prev.next.val;
                }
        }
        
        public void remove(int key) {
            
               int hash = hashIdx(key);
               if(storage[hash] == null){
                return ;
            }
                Node prev = find(storage[hash],key);
             if(prev.next == null){
                    return ;
                }else{
    
                        prev.next = prev.next.next;
                }
    
    
        }
    }
    
  

}
