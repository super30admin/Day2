// Time Complexity : add() - O(2N), remove() - O(2N), contains() - O(N)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : 
    1. One test case was failing for the reason that I had used 'mainArray.length' while checking if element is present in array in add.
    Because of which, element 0 was not getting added to the array (as it already has 0s in it from initialization)
    2. 
*/

class MyHashSet {
    int[] mainArray; //The main array
    int[] tempArray; //The array used to exapand or reduce the size of the main array
    int indexPointer; //Index of the last non-0 element on the array - It will always be pointing to index+1 of the non-0 element

    /** Initialize your data structure here. */
    public MyHashSet() {
        mainArray = new int[10];
        indexPointer = 0; 
    }
    
    public void add(int key) {
        //Check if the element is already present - only till the length that has new elements added to it
        //Do nothing if element is already present
        for(int i=0;i<=indexPointer.length-1;i++)
        {
            if(mainArray[i]==key)
            return;
        }
        //If the indexpointer has reached the last element, increase the size by 10 by copyin all elements to a longer array
        if(indexPointer==mainArray.length-1)
        {
            tempArray = new int[mainArray.length+10];
            System.arraycopy(mainArray, 0, tempArray, 0, mainArray.length);
            mainArray = tempArray;
        }
        mainArray[indexPointer] = key;
        indexPointer++;
    }

    public void remove(int key) {
        /* Loop through the array to check if the element is present. If it is present:
            1. Copy the elements before this particular element and after the element to a new array (leave the key)
            2. Except if the index is 0. In which case, only elements after it are needed to copied
            3. Reduce the pointer as 1 element has been removed
        */
        for(int i=0;i<=indexPointer-1;i++)
        {
            if(mainArray[i]==key)
            {
                tempArray = new int[mainArray.length-1];
                if(i!=0)
                {
                    System.arraycopy(mainArray, 0, tempArray, 0, i);
                }
                System.arraycopy(mainArray, i+1, tempArray, i, mainArray.length-(i+1));
                mainArray = tempArray;
                indexPointer--;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    /*  Loop through the array and return true if element is found */
        for(int i=0;i<=indexPointer-1;i++)
        {
            if(mainArray[i]==key)
            {
                return true;
            }
        }
        return false;
    }
}


public class Sample {
    public static void main(String[] args)
    {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        // System.out.println("\n" + obj.contains(1));
        // System.out.println("\n" + obj.contains(3));
        // obj.add(2);
        // System.out.println("\n" + obj.contains(2));
        obj.remove(1);
        System.out.println("\n" + obj.contains(2));
    }
}