// Time Complexity : O(1)
// Space Complexity : O(n)- I have a doubt in this, I remember Sir told in class, 
//that we need to consider the auxillary space only for the space complexity, and not consider the space needed for output,
//so now do i give o(1), by not considering the spcae for data or consider it and give o(n). Please clarify
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Double hashing
//Time Complexity-
//Problems understading 2d array structure, how values stored bts
class MyHashSet {

    int bucket;
    int secBucket;
    boolean[][] memory;
/** Initialize your data structure here. */
public MyHashSet() {

     bucket=1000;
     secBucket=1000; 
     memory= new boolean[bucket][]; //2-d array for boolean storage

}

public void add(int key) {

    int priIndex= key%1000;      //first hash function
    int secIndex = key/1000;     //second hash function
    if(memory[priIndex]==null)   //in a 2d matrix, default values are null, not false
    {
        if(key==1000000)         //edge case-when key is 1000,000 
        {                
            memory[0]= new boolean[secBucket+1];  //edge case-> when key is 1000,000 
           
        }      
        else
        {
         memory[priIndex]= new boolean[secBucket];   //normal input
        }
    }
    memory[priIndex][secIndex] = true;
    
            
}

public void remove(int key) {
    
    int priIndex= key%1000;//first hash function
    int secIndex = key/1000;//second hash function
    if(memory[priIndex]!=null)//in a 2d matrix, default values are null, not false
    {
     memory[priIndex][secIndex] = false;
    }
  
}

/** Returns true if this set contains the specified element */
public boolean contains(int key) {

    int priIndex= key%1000;     //first hash function
    int secIndex = key/1000;     //second hash function
    if(memory[priIndex]!=null)   //in a 2d matrix, default values are null, not false
    {
     return memory[priIndex][secIndex];
    }
    else
    {
        return false;
    }
    
}
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/