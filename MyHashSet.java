// Time Complexity : O(1) 
// Space Complexity : O(1000*1000) but since it's constant O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
/* 
1. We are maintaining nested array to distribute elements evenly
2. Range of input can be between 0 and 10^6
3. Since we are not dealing with key-value pair here we can make a boolean 2D array that will allow us to check if that index if filled or not. 
3. we are using double hashing to find indexes in the 2D boolean array
4. first hash helps us finds the bucketNumber (row) and the 2nd hash gives us the column number in that row
5. 1000*1000 will give us an array that can store values from 0-99999
6. for 1000000 we have write a specific case since 10^6%1000=0 so it would go to first index 
7. 10^6/1000=0^3 that would give us index outof bound in a typical case so we have to write a special condition that takes care of this and create 1001 columns for 0th row.
*/


public class MyHashSet {
 
    int bucketNo=1000;
    int bucketItems=1000;
    boolean[][] numberMap;
    
    public int hashGenerator(int key)
    {
        return key%bucketNo;
        
    }
    public int doubleHashGenerator(int key)
    {
        return key/bucketItems;
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucketNo=1000;
        bucketItems=1000;
        numberMap=new boolean[bucketNo][];
    }
    
    public void add(int key) {
        int bucketNo=hashGenerator(key);
        int bucketIndex=doubleHashGenerator(key);
        if(numberMap[bucketNo]==null)
        {
            if(bucketNo==0)
              numberMap[bucketNo]=new boolean[bucketItems+1];
            else
            numberMap[bucketNo]=new boolean[bucketItems];
            
        }
        
        numberMap[bucketNo][bucketIndex]=true;
    }
    
    public void remove(int key) {
         int bucketNo=hashGenerator(key);
        int bucketIndex=doubleHashGenerator(key);
        if(numberMap[bucketNo]==null)
        return;
         numberMap[bucketNo][bucketIndex]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketNo=hashGenerator(key);
        int bucketIndex=doubleHashGenerator(key);
        if(numberMap[bucketNo]==null)
            return false;
        return numberMap[bucketNo][bucketIndex];
    }

    public static void main(String[] args)
    {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(3);        
        System.out.println(myHashSet.contains(3));
        myHashSet.remove(3);
        System.out.println(myHashSet.contains(3));

    }

}
