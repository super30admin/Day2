//Two Solutions below
Time: O(1)
Space: O(n)
LeetCode: Yes
Issue: No

// class MyHashSet {
    
//     public class Node{
//         int key;
//         Node prev;
//         Node next;
//         Node(int key){
//             this.key=key;
//         }
//     }
    
//     Node[] set;
//     /** Initialize your data structure here. */
//     public MyHashSet() {
//         set=new Node[1000];
//     }
    
//     private int findIndex(int key){
//         return (Integer.hashCode(key)%1000);
//     }
    
//     public void add(int key) {
//         int index=findIndex(key);
//         if(set[index]==null){ set[index]= new Node(-1);}
//         Node curr=set[index];
//         while(curr.next!=null && curr.next.key!=key){
//             curr=curr.next;
//         }
//         if(curr.next==null){
//             curr.next=new Node(key);
//         }
//         //else it is redundant
//     }
    
//     public void remove(int key) {
//         int index=findIndex(key);
//         if(set[index]==null){ set[index]= new Node(-1);}
//         Node curr=set[index];
//         while(curr.next!=null && curr.next.key!=key){
//             curr=curr.next;
//         }
//         if(curr.next!=null){
//             curr.next=curr.next.next;
//         }
//     }
    
//     /** Returns true if this set contains the specified element */
//     public boolean contains(int key) {
//         int index=findIndex(key);
//         if(set[index]==null){ set[index]= new Node(-1);}
//         Node curr=set[index];
//         System.out.println(curr.key);
//         while(curr.next!=null && curr.next.key!=key){
//             curr=curr.next;
//         }
//         //System.out.println(curr.next.key);

//         if(curr.next!=null){
//             System.out.println(curr.next.key);
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
// }

class MyHashSet {

   int buckets = 1000;

   int bucketItems = 1000;

   boolean [][] storage = new boolean[buckets][];

   public int bucket(int value){ 

       return value%buckets;

   }

   public int bucketItem(int value){ 

       return value/buckets;

   }

   /** Initialize your data structure here. */

   public MyHashSet() {

   }

   public void add(int value ) {

       int bucket = bucket(value);      

       int bucketItem = bucketItem(value);

       if(storage[bucket] == null){

           storage[bucket] = new boolean[bucketItems]; 

       }

       storage[bucket][bucketItem] = true;

   }

   public void remove(int value) {

        int bucket = bucket(value);

        int bucketItem = bucketItem(value);

       if(storage[bucket] != null){

           storage[bucket][bucketItem] = false;

       }

   }

   /** Returns true if this set contains the specified element */

   public boolean contains(int value) {

       int bucket = bucket(value);

       int bucketItem = bucketItem(value);

       return storage[bucket] != null && storage[bucket][bucketItem];

   }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
