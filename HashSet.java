import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: O(n), as I am using ArrayList for the implementation

Space Complexity: O(n)

Did this code successfully run on Leetcode : Yes, results on Leetcode, Runtime: 994 ms, faster than 5.01% of Java online submissions for Design HashSet.
Memory Usage: 56.8 MB, less than 18.86% of Java online submissions for Design HashSet.

Your code here along with comments explaining your approach,
1. I am using ArrayList to store the elements
2. As we know HashSet allows only unique entries, so to add a key I am first checking whether that key already
exists in the set or not, if that exists I am not adding that to set
3. To remove an element, I am checking if that element is there in the list or not, if that exists then only I am
removing that
4. hashSetContains method checks whether the given key already exists in the set or not, if exists already return true,
otherwise false
 */
public class HashSet {
    private List<Integer> list;

    public HashSet(){
        list = new ArrayList<>();
    }

    public void addElement(int key){
        if(!list.contains(key)){
            list.add(key);
            System.out.println("Key: "+key+" added to the set");
        }else{
            System.out.println("Only unique keys are allowed! "+ key + " already exists.");
        }
    }

    public void removeElement(int key){
        if(list.size()>0 && list.contains(key)){
            list.remove(new Integer(key));
            System.out.println("Key: "+key+ " deleted from the set");
        }else{
            System.out.println("Key: "+key+ " does not exists in the set");
        }
    }

    public boolean hashSetContains(int key){
        if(list.contains(key)){
            System.out.println("Wow! HashSet contains key: "+ key);
            return true;
        }else{
            System.out.println("HashSet does not contain key: "+ key + " the key can be added in future");
            return false;
        }
    }

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.addElement(9);
        set.addElement(12);
        set.addElement(15);
        set.removeElement(14);
        set.addElement(16);
        set.removeElement(9);
        set.addElement(16);
        System.out.println(set.hashSetContains(14));
        System.out.println(set.hashSetContains(15));
    }
}


