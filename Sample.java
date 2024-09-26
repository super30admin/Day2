// Time Complexity :Add-O(1), Contains-O(1), Remove-O(1)//Amortized
// Space Complexity :O(n)//  we are using arraylist.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No




// Your code here along with comments explaining your approach
class MyHashSet {
    ArrayList<Integer> al;
    public MyHashSet() {
        al = new ArrayList<>();
    }
    
    public void add(int key) {
        al.add(key);
    }
    
    public void remove(int key) {
        Iterator itr=al.iterator();
        while(itr.hasNext())
        {
            if(itr.next().equals(key))
                itr.remove();
        }
    }
    
    public boolean contains(int key) {  
       for(int i=0;i<al.size();i++)
       {
           if(al.get(i)==key)
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

