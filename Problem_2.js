// Time Complexity :
// For all - Put, Get and Remove:
// Worst case will be Object(N) where N is the length of the secondary array i.e. 100.
// Since 100 is not a large number we can say thet the operations have a constant time.

// Space Complexity : O(N) where N is the max range of inserted numbers
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 706. Design HashMap

// The Node object will have 3 information: key, value and next Node's address
class Node {
    constructor(key, value, next) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

var MyHashMap = function () {
    // Buckets is the length of primary array(nodes[]). It is set as 10^4 because we want the secondary linked list size to be smaller
    // The data will be stored in linked list and smaller length of secondary array ensures that search time for elements is less
    this.buckets = 10000;
    this.nodes = new Array(this.buckets);
};

MyHashMap.prototype.getBucket = function (key) {
    // Using the hashing function, we ensure that each key has a deterministic index
    return key % this.buckets;
};

// Find function will be used for all Hashmap operations to find the element in the secondary linked list.
// Hence, it is extracted to make the code modular
MyHashMap.prototype.find = function (key, node) {
    // For each find, the prev node will be the dummy node 
    // and the curr node will point to the start of data stored in hashmap by user
    let prev = node;
    let curr = node.next;
    // Search till curr points to node with key or reaches end of linked list
    while (curr != null && curr.key !== key) {
        prev = curr;
        curr = curr.next;
    }
    // Return previous. The info for the element to find will be in 'prev.next'
    return prev;
};

/** 
* @param {number} key 
* @param {number} value
* @return {void}
*/
MyHashMap.prototype.put = function (key, value) {
    // Get the primary array index
    let bucket = this.getBucket(key);

    // If there is no linked list at the position, create one with dummyhead (-1,-1)
    if (!this.nodes[bucket]) {
        this.nodes[bucket] = new Node(-1, -1);
    }
    // Find the key in the secondary linked list
    let prev = this.find(key, this.nodes[bucket]);

    // Did not find key, create a new node with key-value and add at end
    if (prev.next === null) {
        prev.next = new Node(key, value);
        return;
    }
    // Found key, update value
    prev.next.value = value;
};

/** 
* @param {number} key
* @return {number}
*/
MyHashMap.prototype.get = function (key) {
    let bucket = this.getBucket(key);
    if (!this.nodes[bucket]) {
        return -1;
    }
    let prev = this.find(key, this.nodes[bucket]);
    // Did not find key, return -1
    if (prev.next === null) {
        return -1;
    }
    // Found key, return value
    return prev.next.value;
};

/** 
* @param {number} key
* @return {void}
*/
MyHashMap.prototype.remove = function (key) {
    let bucket = this.getBucket(key);
    if (!this.nodes[bucket]) {
        return;
    }
    let prev = this.find(key, this.nodes[bucket]);
    // Did not find key, return
    if (prev.next === null) {
        return;
    }
    //Found key to remove
    let temp = prev.next;
    prev.next = prev.next.next;
    temp.next = null;
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */