    /*  Explanation
    Time Complexity for operators : o(1)   
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    The implementation consists of two has functions that generates two different keys.
    We are going to use an 2-D array that is of type boolean. We do not need to implemenmt get function that's why
    boolean array will work. In add function, the true value gets added on the generated two indexes.
    Similarly, in case of remove functionality. 
    */

public class designHasjSet{


    public static void main(String args[]){
        designHasjSet hashsetdesign = new designHasjSet();
        hashsetdesign.add(1);
        hashsetdesign.add(11);
        System.out.println(hashsetdesign.contains(15));
    }   

    private int bucket = 1000;
    private int bucketItem = 1000;
    
    private boolean hashSet[][];

    public designHasjSet(){
        hashSet = new boolean[bucket][];
    }
    
    private int hashModuloFunction(int key){
        return key%bucket;
    }
    
    private int hashDivideFunction(int key){
        return key/bucketItem;
    }
    
    public void add(int key) {
        int index1 = hashModuloFunction(key);
        int index2 = hashDivideFunction(key);
        
        if(hashSet[index1]==null){
            hashSet[index1] = new boolean[bucketItem];
        }
        
        hashSet[index1][index2]=true;
        
    }
    
    public void remove(int key) {
        int index1 = hashModuloFunction(key);
        int index2 = hashDivideFunction(key);
        
        if(hashSet[index1]==null){
            return;
        }
        
        hashSet[index1][index2]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashModuloFunction(key);
        int index2 = hashDivideFunction(key);
        
        return hashSet[index1] != null && hashSet[index1][index2];
    }
}