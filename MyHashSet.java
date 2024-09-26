// Time Complexity : Add O(1) Remove and contains 0(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Choosing the right structure and array size ( MAX )

// Your code here along with comments explaining your approach


import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    
    
    List<Integer>[] list;
    int MAX=100001;

    public MyHashSet() {        
        list=new List[MAX];
    }
    
    public int getArrayIndex(int key)
    {
        return key%MAX;
    }
    public void add(int key) {
        
        int slot=getArrayIndex(key);
        if(list[slot]==null)
        {
            ArrayList<Integer>posList=new ArrayList<>();
            posList.add(key);
            list[slot]=posList;
            //System.out.println(list[slot]);
        }
        else
        {
            List<Integer>posList=list[slot];
            if(!contains(key))
                posList.add(key);
            System.out.println(posList);
        }
        
    }
    
    public void remove(int key) {
    
    // Get Slot or index of key in array . Then the list there is not empty , then remove it     
    int slot=getArrayIndex(key);
    if(list[slot]!=null && list[slot].size()!=0)
    {
        List<Integer>posList=list[slot];
        System.out.println(posList.size());
        int index=0;
        for(int i=0;i<posList.size();i++)
        {
            if(posList.get(i)==key)
                index=i;
        }
        System.out.println(index);
        //posList.remove(index);
        list[slot]=null;
    }
    
    }
    
    public boolean contains(int key) {
        
        int slot=getArrayIndex(key);
        List<Integer>list1=list[slot];
        //System.out.println(list1);
        
        if(list1==null)
            return false;
        
        for(int i=0;i<list1.size();i++)
        {
            if(list1.get(i)==key)
                return true;
        }
         return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */