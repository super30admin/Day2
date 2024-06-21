
// Time Complexity : O(1)
// Space Complexity : O(N) constant space as the space is known
// Did this code successfully run on Leetcode : Yes, submitted and successfully passed all the test cases
// Any problem you faced while coding this : No

class MyHashMap
{
    //As the max number of operations given in the contraints is 10000 that would be the size.
    Node [] nodes = new Node[10000];
    //Let me create a node class
    class Node{
        int key;
        int value;

        Node next;
        //Parameterised constructor
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    /*
        Index function for hashing
    */
    private int index(int key)
    {
        return key%nodes.length;
    }

    //Function to get the argument
    public Node find(Node head, int key)
    {
        //the curr node will be curr 
        Node curr = head;
        Node prev = null; // prev initialised to null
        //Iterate over the nodes till you find the key or reach the end.
        while(curr!=null && curr.key!=key)
        {
            //Assign curr as prev and assign curr.next to curr
            prev = curr;
            curr = curr.next;
        }
    
        return prev;
    }
   //Constructor
    public MyHashMap()
    {

    }
   
    public void put(int key, int value)
    {
           
       //look for an index using the hashing function index
        int i = index(key);
       //check if the value at the index i is null
        if(nodes[i]==null)
        {
            //assign the values to dummy values (-1,-1)
            nodes[i]=new Node(-1,-1);
        }
        //get the position of the previous node to put the new key, value pair
        //Call the find function and store in a prev node
        Node prev = find(nodes[i],key);
        //if the next position is empty add the key and node to prev.next position
        if(prev.next == null)
        {
            prev.next = new Node(key, value);
        }
        else
        {
            //Update the value to given value
            prev.next.value = value;
        }
    }

    public int get(int key)
    {
        //get index
        int i = index(key);
        //check if it is null if so no such key so return -1
        if(nodes[i]==null)
        {
            return -1;
        }
        //Find prev location using find function
        Node prev = find(nodes[i], key);
        // if next is null then return -1
        if(prev.next == null)
        {
            return -1;
        }
        //return the value at prev.next
        return prev.next.value;
    }

    public void remove(int key)
    {
        //get the index for the key
        int i = index(key);
        //if value at index is null return as nothing to remove
        if(nodes[i]==null)
        {
            return;
        }
        //find prev using the find funct
        Node prev = find(nodes[i], key);
        //If the next value is null then return
        if(prev.next == null)
        {
            return;
        }
        //if found make prev.next as prev.next.next to delete the node
        else
        {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */