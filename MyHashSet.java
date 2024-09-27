import java.util.*;
class Bucket{
    private List<Integer> bucket;
     public Bucket(){
         this.bucket=new LinkedList<Integer>();
     }
     
     public void add(Integer x){
          boolean ans=false;
         for(Integer m:bucket){
            if(m.equals(x)){
                ans=true;
               break;
                
            }
     }
         if(!ans){
                 bucket.add(x);
             }
     }
     
     
     public boolean contains(Integer x){
         boolean ans=false;
          for(Integer m:bucket){
              if(m.equals(x)){
                  ans=true;
                  break;
              }
              
          }
         return ans;
     
     }
     
     public void remove(Integer x){
     
        for(Integer m:bucket){
            if(m.equals(x)){
                bucket.remove(x);
                break;
                
            }
            
        }
         
         
     }
 }
 
 class MyHashSet {
      int k;
     List<Bucket> hash;
 
     /** Initialize your data structure here. */
     public MyHashSet() {
         this.k=2069;
         this.hash=new ArrayList<>();
          for(int i=0;i<this.k;i++){
         hash.add(new Bucket());
         }
     }
     
     public void add(int key) {
         int hashkey=key%k;
         hash.get(hashkey).add(key);
         
     }
     
     public void remove(int key) {
         int hashkey=key%k;
         hash.get(hashkey).remove(key);
         
     }
     
     /** Returns true if this set contains the specified element */
     public boolean contains(int key) {
         int hashkey=key%k;
         return hash.get(hashkey).contains(key);
     }
     public static void main(String args[]){
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
 
 /**
  * Your MyHashSet object will be instantiated and called as such:
  * MyHashSet obj = new MyHashSet();
  * obj.add(key);
  * obj.remove(key);
  * boolean param_3 = obj.contains(key);
  */