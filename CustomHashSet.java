import java.util.NoSuchElementException;

class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class CustomHashSet<T> {

	private static final Integer INITIAL_CAPACITY = 16;
	private Node<T>[] buckets;
    private int size;
	
    public CustomHashSet(final int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    public CustomHashSet() {
        this(INITIAL_CAPACITY);
    }
    
    public void add(T t) {
        int index = hashCode(t) % buckets.length;

        Node bucket = buckets[index];

        Node<T> newNode = new Node<>(t);

        if (bucket == null) {
            buckets[index] = newNode;
            size++;
            return;
        }

        while (bucket.next != null) {
            if (bucket.data.equals(t)) {
                return;
            }
            bucket = bucket.next;
        }

        // add only if last element doesn't have the value being added
        if (!bucket.data.equals(t)) {
            bucket.next = newNode;
            size++;
        }
    }
    
    public T remove(T t) {
        int index = hashCode(t) % buckets.length;

        Node bucket = buckets[index];

        if (bucket == null) {
            throw new NoSuchElementException("No Element Found");
        }

        if (bucket.data.equals(t)) {
            buckets[index] = bucket.next;
            size--;
            return t;
        }

        Node prev = bucket;

        while (bucket != null) {
            if (bucket.data.equals(t)) {
                prev.next = bucket.next;
                size--;
                return t;
            }
            prev = bucket;
            bucket = bucket.next;
        }
        return null;
    }
    
    public T contains(T t){
    	int index = hashCode(t) % buckets.length;
        if(buckets[index] == null){
         return null;
        }else{
         Node<T> temp = buckets[index];
         while(temp!= null){
             if(temp.data.equals(t))
                 return t;
             temp = temp.next; //return value corresponding to key.
         }         
         return null;   //returns null if key is not found.
        }
    }

    private int hashCode(T t){
        return Math.abs(t.hashCode()) % INITIAL_CAPACITY;
    }
	

	public static void main(String[] args) {
		CustomHashSet<Integer> set = new CustomHashSet<>();
		set.add(3);
	    set.add(4);
	    set.add(8);
	    set.add(4);
	    System.out.println(set.size);
	    set.remove(8);
	    System.out.println(set.size);
		
	}
}
//Time Complexity : add,remove - O(1)
//Space Complexity : add,remove - O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Was not able to solve on own, took help from google