// Time Complexity : O(n) where the N is the number of elements in the array
// Space Complexity :O(N) where the N is the number of elements in the array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//we defined 2 hashfunctions one on basis of modulo and other on basis of /


class MyHashSet {

    /** Initialize your data structure here. */
    int bucketsize = 1000;
    int bucketitemsize = 1000;
    boolean hashset [][];
    
    public MyHashSet() {
        hashset = new boolean[1000][];
        
    }
    
    public int bucketindex(int key){
          return (key%bucketsize);
    }
    
    
    public int bucketitemindex(int key){
          return (key/bucketitemsize);
    }
    

  // Inserting element into 2 dimensional array on the basis of hash functions created before
  //If it is the first element that has no array to store elements,we create array and then on 
  //basis of  bucketitemindex hash function and then initialize to true else initialize by 
 //going to the arrayelemnt on hashfunction2 and initializing to true
    public void add(int key) {
        int bi = bucketindex(key);
        int bIi = bucketitemindex(key);
        if(hashset[bi]==null){
            hashset[bi]= new boolean[bucketitemsize];
        }
        hashset[bi][bIi]=true;
    }
    
 //If the ar[firsthash function] is not null then  we calculate arr[hash1fun][hash2fun] to false
    public void remove(int key) {
        int bi = bucketindex(key);
        int bIi = bucketitemindex(key);
           if(hashset[bi]!=null)
              hashset[bi][bIi]=false;
        
    }
    
    /** Returns true if this set contains the specified element else false, The element that is 
    //not in the array fails on second condition, if no elements are present for first hashfun
    //throws false 
    public boolean contains(int key) {
        int bi = bucketindex(key);
        int bIi = bucketitemindex(key);
        return ((hashset[bi]!=null) && hashset[bi][bIi]);
      }
     }



// Time Complexity : o(1)
// Space Complexity :O(N) where the N is the number of elements in the array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No



class MyQueue {

   private Stack<Integer> input = new Stack<>();
   private Stack<Integer> output = new Stack<>();
    int front;
    
    public void push(int x) {
        input.push(x);
    }
    
    
    public void shift(){
        
        if (output.isEmpty())
        {
            while (!input.isEmpty())
                output.push(input.pop());
        }
          
    }

    public void pop() {
      
    shift();    
    output.pop();
    }

    public int peek() {
        shift();
        return (output.peek());
       
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}