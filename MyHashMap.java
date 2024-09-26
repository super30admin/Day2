import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
	/** Double hashing| Time O(n) | Space O(n) **/
	private List<Integer[]> list;	
	
	public MyHashMap() {		
	    list=new ArrayList<Integer[]>();
	}

	public void put(int key, int value) {	
		boolean flag= false;
		if(!list.isEmpty()) {
			for(Integer[] arr: list) {
				if(arr[0] == key) {
					arr[1]=value;
					flag=true;
				}
			}
		}
		
		if(list.isEmpty() || !flag) {
			Integer[] item = new Integer[] {key, value};
			list.add(item);
		}
	}

	public int get(int key) {
		if(!list.isEmpty()) {
			for(Integer[] arr: list) {
				if(arr[0] == key) {
					return arr[1];
				}
			}
		}
	    return -1;
	}

	public void remove(int key) {
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i)[0] == key) {
					list.remove(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 2);
		hashMap.put(2, 3);
		hashMap.get(1); // returns 2
		hashMap.get(3); // returns -1 (not found)
		hashMap.put(2, 4); // update the existing value
		hashMap.get(2); // returns 4
		hashMap.remove(2); // remove the mapping for 2
		hashMap.get(2); // returns -1 (not found)
	}
}
