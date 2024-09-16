//design hashset- 

//Approach- Brute Force- Using an array- Not using hashing so not efficient
//and therefore cannot satify at most 104 calls made to the operations.

/* Constraints given:
0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.

Complexity analysis:
Time- O(N)
Space- O(N)

*/


boolean[] arr = new boolean[1000001];

/** Initialize your data structure here. */
public MyHashSet() {
    
}

public void add(int key) {
    arr[key] = true;
}

public void remove(int key) {
    arr[key] = false;
}

/** Returns true if this set contains the specified element */
public boolean contains(int key) {
    return arr[key];
}
}