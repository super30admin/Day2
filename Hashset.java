class MyHashSet {

    Node arr[];
    
    
    class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            
            this.val=val;
            
        }
        
        
        
    }
    
    
    public MyHashSet() {
        this.arr=new Node[10000];
        for( int i=0;i<arr.length;i++){
            
            Node h=new Node(-1);
            Node t= new Node(-1);
            h.next=t;
            this.arr[i]=h;
            
        }
          
        
    }
    
    
    
    public void add(int key) {
      if(contains(key)){return ;}
    int index=Integer.hashCode(key)%arr.length;
     
      Node p=arr[index];
        
        while(p.next.val!=-1){
            p=p.next;
            
        }
        
        Node t =p.next;
        
        p.next= new Node(key);
       
        p=p.next;
        p.next=t;
        
        
    Node p1=arr[index];
    
        
        while(p1!=null){
        
     //  System.out.println(p1.val);
        p1=p1.next;
    }
        
        
        
    }
    
    
    
    
    public void remove(int key) {
     
        if(contains(key)){
        
      int index=Integer.hashCode(key)%arr.length;
            
            Node p1=arr[index];
            Node p2=p1.next;
            
            while(p2.val!=key){
                p1=p2;
                p2=p2.next;
            }
            
            
            p1.next=p2.next;
            
        }
        
        
            
    }
    
    
    
    
    public boolean contains(int key) {
        
    int index=Integer.hashCode(key)%arr.length;
        
       Node p=this.arr[index];
   
        
        while(p.next!=null&&p.val!=key){
         
             p=p.next;        
            
        }
       // System.out.println("brk"); 
        if(p.val==key){return true;}else{return false;}
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */