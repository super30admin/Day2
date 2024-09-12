import java.util.*;

/*
    ArrayList is used to implement HashSet. 
*/
public class MyHashSet {

    public static ArrayList<Integer> list;

    public MyHashSet() {
        
        list = new ArrayList<>();

    }
    
    //Time Complexity : O(1)
    //Space Complexity: O(1)
    public void add(int key) {
        
        if(!list.contains(key))
        {
            list.add(key);
        }
          
    }
    
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public void remove(int key) {
        
        
        if(list.contains(key))
        {
            System.out.println("The element "+list.remove(new Integer(key))+" is removed");
            
        }
        else if(!list.contains(key))
        {
            System.out.println("No such number exists");
        }
    }
    
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public boolean contains(int key) {
        
        return list.contains(key)==true;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public  void print()
    {
        for(int i =0;i<list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }



    public static void main(String args[])
    {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(4);
        set.print();
        set.remove(4);
        System.out.println("Does the HashSet contain "+ 4+"? "+set.contains(4));
        System.out.println("Does the HashSet contain "+ 48+"? "+set.contains(48));

        

    }
}