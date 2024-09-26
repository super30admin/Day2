// Time Complexity : add =O(1) remove=O(1) Contains=O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HashSet{

    int[] set;
    public HashSet(int length){
        set = new int[length];
        Arrays.fill(set, Integer.MIN_VALUE);
    }

    // Generate an index based on the value to be inserted
    public int index(int value){
        return (value%set.length);
    }

    // add the value in the set
    public void add(int value){

        if(contains(value)){
            return;
        }else{
            int tempIndex = index(value);
            set[tempIndex] = value;

        }

    }

    //check if the value already exist in the set
    public boolean contains(int value){
        int tempIndex = index(value);
        if(set[tempIndex] == Integer.MIN_VALUE){
            return true;
        }
        return false;

    }

    // remove the value from the set
    public void remove(int value){
        if(!contains(value)){
            return;
        }else{
            int tempIndex = index(value);
            set[tempIndex] = Integer.MIN_VALUE;
        }

    }
 }