// Operation:           add     remove     contains
// Time Complexity:     O(n)     O(1)        O(n)
// Space Complexity:    O(n)     O(n)        O(n)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement in Brute force approach

package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateHashset
{
    public static void main(String[] args) {
        Create obj = new Create() ;
        obj.add(1);
        obj.remove(1);
        boolean param_3 = obj.contains(1);
        System.out.println(param_3);
    }
}

class Create
{
    private final int MAX_VAL = 1000000 ;
    private final int ARRAY_SIZE = 1000 ;
    private List<List<Integer>> parentList ;

    public Create() {
        parentList = new ArrayList<>(ARRAY_SIZE) ;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentList.add(null) ;
        }
    }

    public void add(int key) {
        int index = key % ARRAY_SIZE ;
        List<Integer> childList = parentList.get(index) ;

        if(childList == null)                                   // No element in childList
        {
            List<Integer> list = new LinkedList<>() ;
            list.add(key) ;                                     // Adding key in childList
            parentList.set(index, list) ;                       // Adding childList to parentList
        }
        else                                                    // childList not Empty
        {
            if(!childList.contains(key))                        // key not exits then simply add key in childList
            {
                childList.add(key) ;
            }
        }
    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE ;
        List<Integer> childList = parentList.get(index) ;

        if(childList != null)                                   // If childList not empty then remove key
        {
            childList.remove(Integer.valueOf(key)) ;
        }
    }

    public boolean contains(int key) {
        int index = key % ARRAY_SIZE ;
        List<Integer> childList = parentList.get(index) ;

        return ( childList != null && childList.contains(key) ) ;   // childList not null and contains key
    }
}




