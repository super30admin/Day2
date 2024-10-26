// Time Complexity : put, get, remove O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Node {
  constructor(key, value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

var MyHashMap = function () {
  this.bucket = 10000;
  this.storage = new Array(this.bucket).fill(null);
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
  let primaryIndex = this.getPrimaryHash(key);
  if (this.storage[primaryIndex] == null) {
    this.storage[primaryIndex] = new Node(-1, -1);
  }
  let previousNode = this.getPreviousNode(this.storage[primaryIndex], key);
  if (previousNode.next == null) {
    previousNode.next = new Node(key, value);
  } else {
    previousNode.next.value = value;
  }
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
  let primaryIndex = this.getPrimaryHash(key);
  if (this.storage[primaryIndex] == null) {
    return -1;
  }
  let previousNode = this.getPreviousNode(this.storage[primaryIndex], key);
  if (previousNode.next == null) {
    return -1;
  } else {
    return previousNode.next.value;
  }
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
  let primaryIndex = this.getPrimaryHash(key);
  if (this.storage[primaryIndex] == null) {
    this.storage[primaryIndex] = new Node(-1, -1);
  }
  let previousNode = this.getPreviousNode(this.storage[primaryIndex], key);
  if (previousNode.next == null) {
    return -1;
  } else {
    previousNode.next = previousNode.next.next;
  }
};

MyHashMap.prototype.getPreviousNode = function (node, key) {
  previousNode = null;
  currentNode = node;
  while (currentNode != null && currentNode.key != key) {
    previousNode = currentNode;
    currentNode = currentNode.next;
  }
  return previousNode;
};

MyHashMap.prototype.getPrimaryHash = function (key) {
  return key % this.bucket;
};

//  * Your MyHashMap object will be instantiated and called as such:

test("Scenario #1:", () => {
  var obj = new MyHashMap();
  obj.put(1, 1);
  obj.put(2, 2);

  expect(obj.get(1)).toStrictEqual(1);
  expect(obj.remove(5)).toStrictEqual(-1);
});
