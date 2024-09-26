// Time Complexity :O(N/K) K IS THE BASE
// Space Complexity :O(N/K*M)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : IT TOOK TIME FOR ME TO DEBUG BUT WAS ABLE TO FINISH


// Your code here along with comments explaining your approach
// CREATED AN NODE ARRAY OF SIZE SQUARE ROOT OF 1000000 ADDED KEY IN THE GIVEN POSITION IF THE KEY ALREADY EXISTS CREATED A LINKED LIST SIMILARLY REMOVED IT FROM THE POSITION FOR DELETE FUNCTION CHECK THE ARRAY AND LINKEDLIST FOR THE CONTAINS FUNCTION


class MyHashSet {
    
    class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }
    }
    int base=1000;
    node[] hasharray;
    public MyHashSet() {
        hasharray=new node[base];
        
    }
    
    public void add(int key) {
        int position=key%base;
        node temp=new node(key);
        if(hasharray[position]==null){
            hasharray[position]=temp;
        }
        node check=hasharray[position];
        while(check.next!=null)
        {
            if(check.data==key)
                return;
            check=check.next;
        }
        if(check.data==key)
            return;
        else{
            temp.next=hasharray[position];
            hasharray[position]=temp;
        }
    }
    
    public void remove(int key) {
        int position=key%base;
        if(hasharray[position]==null){
            return;
        }
        if(hasharray[position].next==null && hasharray[position].data==key){
            hasharray[position]=hasharray[position].next;
            return;
        }
        if(hasharray[position].next!=null){
            node curr=hasharray[position];
            node prev=hasharray[position];
            if(hasharray[position].data==key){
                curr=curr.next;
                hasharray[position]=curr;
                
                return;
            }
            while(curr.next!=null && curr.data!=key){
                prev=curr;
                curr=curr.next;
                if(curr.data==key){
                    prev.next=curr.next;
                    return;}
            }
            if(curr.next==null && curr.data==key)
                prev.next=curr.next;
        }
        
    }
    
    public boolean contains(int key) {
       int position=key%base;
       if(hasharray[position]==null)
           return false;
       if(hasharray[position].next==null){
           return hasharray[position].data==key;
       }
        
        
       if(hasharray[position].next!=null){
            node temp=hasharray[position];
           while(temp.next!=null && temp.data!=key)
               temp=temp.next;
           if(temp.data==key)
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