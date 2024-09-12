class MyHashSet {
    ListNode[] node= new ListNode[100];

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int y= hash(key);
        ListNode head=findIndex(y,key);
        if(head.next==null)
        {   head.next= new ListNode(key);
        }

         if(head.next.key==key)
            {return;}
            
            head.next.key=key;
        
        
    }
    
    public void remove(int key) {
        int index = hash(key);
        ListNode head = findIndex(index, key);
			
        if(head.next != null)
		    head.next = head.next.next;
        
    }
    public int hash(int key)
    {   int x= key % 100;
        return x;
        
    }
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
         int y= hash(key);
        ListNode head=findIndex(y,key);
        if(head.next==null)
        {
            return false;
        }
        if(head==null)
        {return false;}
        if(head.next.key==key)
        {
            return true;
        }
        return false;
    }
    public ListNode findIndex(int x,int key)
    {
        if(node[x]==null)
        {
            return node[x] = new ListNode (-1);
        }
        ListNode head = node[x]; 
        while(head.next != null && head.next.key != key)
		{
			head = head.next;
            
		}
		return head; //if key value matches then update the value at that key, if key value doesnt match then traverse to the end of linked list of that index
	}
            
    
private static class ListNode
{
    ListNode next;
    int key;
    ListNode(int key)
    {   this.key=key;
        
    }
    
}


}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */