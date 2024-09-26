//Time Complexity : put, get, remove- O(1) constant time
//Space Complexity : O(n) i.e. O(n), n is size of (Primary)Array. Here though size of n is taken as square root of(10^6)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Yes on VS, I had faced some issues. Like remove method is not working properly

//Your code here along with comments explaining your approach

/*Step 1: I am designing HashMap using dynamic arrays. I first initialize the primary array with NULL. 
 * Step 2: If we will initialize array with given size i.e. 10^6 and has to store just 2 elements. Then it will be simply wastage of memory. Hence, we will initialize array with just 10^3 size.
 * Step 3: We will perform mod% operation to find the index to store key and value pair. for values greater than calculated size(10^3) and less than given size(10^6).
 Step 4: In order to avoid collisions, we will again use divide operator to find index to store key and value in LinkedList. If primary index is NULL, then first we will create dummy node of LinkedList and consider it as Head. to avooid prev pointer related iossues
 for that index pointer and then perform / operations through functions to find key, value pair.
 */

import java.util.*;
public class designHashMap {
	
	    static class Node{
	        int key, value;
	        Node next;
	        Node(int key, int value)
	        {
	            this.key=key;
	            this.value=value;
	        }
	    }
	    
	    static Node[] nodes;
	    static int bucket;
	    
	    private static int getbucket(int key)
	    {
	        return key%bucket;
	    }
	    
	    public static void designHashMap() {
	    	 bucket=1000;
		     nodes= new Node[bucket];
	    	
	    }
	    
	    public static Node find(Node head, int key)
	    {
	        Node prev=head;
	        Node curr= head.next;
	        while(curr!=null && curr.key != key){
	            prev=curr;
	            curr=curr.next;
	        }
	        return prev;
	    }
	    
	    public static void put(int key, int value) {
	        int index = getbucket(key);
	        if(nodes[index] == null)
	        {
	            nodes[index]=new Node(-1,-1);
	        }
	        Node prev=find(nodes[index],key);
	        if(prev.next==null)
	        {
	            prev.next=new Node(key,value);
	            System.out.println("Key is added");
	        }
	        else {
	        prev.next.value=value;
	        System.out.println("Value is updated");}
	    }
	    
	    public static void get(int key) {
	        int index = getbucket(key);
	        if(nodes[index] == null)
	        {
	        	System.out.println("Key is not present");
	        }
	        Node prev=find(nodes[index],key);
	        if(prev.next==null)
	        {
	            System.out.println("key is not present");
	        }else {
	        System.out.println("Key is present and it's value is: "+prev.next.value);}
	    }
	    
	    public static void remove(int key) {
	        int index = getbucket(key);
	        if(nodes[index] == null)
	        {
	        	System.out.println("key is not present to be removed");
	        }
	        Node prev=find(nodes[index],key);
	        if(prev.next==null)
	        {
	        	System.out.println("key is not present to be removed");
	        }
	        else {
	         prev.next=prev.next.next;
	         System.out.println("key is removed");}
	    }

public static void main(String[] args) {
	
	designHashMap();
	Scanner inpObj = new Scanner(System.in); 
    do
	{
    	System.out.println("Enter the operation(put, get, remove) and Q/q to exit \n");
    	String text = inpObj.nextLine(); 
    	if(text.equals("Q") || text.equals("q"))
    	{
    		break;
    	}
    	if(text.equals("put"))
    	{
    		System.out.println("Please enter the integer key element you want to add into HashSet");
    		Scanner sc= new Scanner(System.in); 
    		int num=sc.nextInt();
    		System.out.println("Please enter the integer value element you want to add into HashSet");
    		Scanner sc1= new Scanner(System.in); 
    		int num1=sc.nextInt();
    		put(num, num1);
    	}
    	if(text.equals("get"))
    	{
    		System.out.println("Please enter the integer element you want to check into HashSet");
    		Scanner sc= new Scanner(System.in); 
    		int num=sc.nextInt();
    		get(num);
    	}
    	if(text.equals("remove"))
    	{
    		System.out.println("Please enter the integer element you want to remove from HashSet");
    		Scanner sc= new Scanner(System.in); 
    		int num=sc.nextInt();
    		remove(num);
    	}
    	
	}	while(true);
}
}

