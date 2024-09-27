import java.util.Arrays;

class MyEntry {
	int E;
	int V;

	public MyEntry(int E, int V) {
		super();
		this.E = E;
		this.V = V;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	@Override
	public String toString() {
		return "[" + E + "=" + V + "]";
	}
}

class MyLinkedList {
	MyEntry entry;
	MyLinkedList next;

	public MyLinkedList() {

	}

	public MyLinkedList(MyEntry entry) {
		super();
		this.entry = entry;
		this.next = null;
	}

	public MyLinkedList(MyEntry entry, MyLinkedList next) {
		super();
		this.entry = entry;
		this.next = next;
	}

	public MyEntry getEntry() {
		return entry;
	}

	public void setEntry(MyEntry entry) {
		this.entry = entry;
	}

	public MyLinkedList getNext() {
		return next;
	}

	public void setNext(MyLinkedList next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "MyLinkedList [value=" + entry + ", next=" + next + "]";
	}
}

public class MyHashSet {

	private static int PRESENT = 1;
	private int CAPACITY;
	private int counter;

	private MyLinkedList[] nodes;

	public MyHashSet() {
		this.CAPACITY = 10;
		this.nodes = new MyLinkedList[this.CAPACITY];
	}

	public MyHashSet(int capacity) {
		this.CAPACITY = capacity;
		this.nodes = new MyLinkedList[this.CAPACITY];
	}

	public int hashCode(int key) {
		return key << 1;
	}

	public boolean isFull() {
		return counter == this.nodes.length;
	}

	public MyLinkedList push(MyLinkedList head, int key, int value) {

		MyLinkedList node = new MyLinkedList(new MyEntry(key, value));

		MyLinkedList current = head;
		while (current != null) {
			if (current.getEntry().getE() == key) {
				current.entry.setV(value);
			}
			current = current.getNext();
		}
		if (head == null)
			head = node;
		return head;
	}

	public MyLinkedList remove(MyLinkedList head, int key) {
		MyLinkedList current = head;
		if (head.next == null) {
			head = null;
			return head;
		}
		while (current != null && current.getEntry().getE() != key) {
			current = current.getNext();
		}
		if (current.next != null) {
			System.out.println("Value  " + key + " not present");
		}
		current.next = current.next.next;
		return current;
	}

	public void add(int key) {
		put(key, PRESENT);
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash = hashCode(key);
		MyLinkedList node = nodes[hash];
		if (node == null) {
			nodes[hash] = push(null, key, value);
		} else {
			nodes[hash] = push(node, key, value);
		}
		print();
	}

	/**
	 * Returns the value to which the specified key is setped, or -1 if this set
	 * contains no setping for the key
	 */
	public int get(int key) {
		int hash = hashCode(key);
		MyLinkedList node = nodes[hash];
		while (node != null) {
			if (node.getEntry().getE() == key) {
				return node.getEntry().getV();
			}
			node = node.getNext();
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int hash = hashCode(key);
		MyLinkedList node = nodes[hash];

		if (node == null) {
			System.out.println(key + " is not present");
		} else {
			nodes[hash] = remove(nodes[hash], key);
		}
		print();
	}

	public void print() {
		System.out.println(Arrays.toString(nodes));
	}

	public boolean contains(int key) {
		return get(key) != -1;
	}
	
	public static void main(String args[]) {
		MyHashSet set = new MyHashSet();
		set.add(1);
		set.add(2);
		set.add(1);
		System.out.println(set.contains(2));
		//set.remove(2);
		//set.remove(2);
		System.out.println(set.get(2));
	}

}
