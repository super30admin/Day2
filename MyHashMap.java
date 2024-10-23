/*
Approach - Using a custom node class to store key, val and next
Created a new Node[] to store all the primary keys which would point to the head node

put - TC - O(1)  SC - O(1)
get - TC - O(1) SC - O(1)
remove - TC - O(1) and SC - O(1)

 */

/**
 * MyHashMap : MyHashMap
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 23, 2024)
 * @since : 1.0 (Oct 23, 2024)
 */
class MyHashMap {
	class Node{
		int key;
		int val;
		Node next;
		public Node(int key, int val){
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}
	Node[] map;
	
	public MyHashMap() {
		this.map = new Node[10000];
	}
	
	private int getPrimaryKey(int key){
		return key % 10000;
	}
	
	private Node getPrev(Node head, int key){
		Node prev = null;
		while(head != null){
			if(head.key == key){
				break;
			}else{
				prev = head;
				head = head.next;
			}
		}
		return prev;
	}
	
	public void put(int key, int value) {
		int primary = getPrimaryKey(key);
		if(map[primary] == null){
			map[primary] = new Node(-1, -1);
		}
		Node head = map[primary];
		Node prev = getPrev(head, key);
		Node curr = new Node(key, value);
		if(prev.next == null){
			prev.next = curr;
		}else{
			prev.next.val = value;
		}
	}
	
	public int get(int key) {
		int primary = getPrimaryKey(key);
		if(map[primary] == null){
			return -1;
		}
		Node head = map[primary];
		Node prev = getPrev(head, key);
		if(prev.next == null){
			return -1;
		}
		return prev.next.val;
	}
	
	public void remove(int key) {
		int primary = getPrimaryKey(key);
		if(map[primary] == null){
			return;
		}
		Node head = map[primary];
		Node prev = getPrev(head, key);
		if(prev == null){
			return;
		}
		Node curr = prev.next;
		prev.next = curr.next;
		curr.next = null;
		
	}
	
	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 1);
		myHashMap.put(2, 2);
		myHashMap.put(3, 3);
		System.out.println(myHashMap.get(2));
		myHashMap.remove(2);
		System.out.println(myHashMap.get(2));
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */