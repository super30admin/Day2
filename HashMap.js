// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Facing difficulty with js syntax as it is not typed.I need to practise using typescript.

// TODO: Need to practise writing using Typescript
class Node {
  constructor(key, value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

class HashMap {
  constructor() {
    this.nodes = new Node(10000);
    this.buckets = 10000;
  }

  getBucket = (key) => {
    return key % this.buckets;
  };

  find = (head, key) => {
    const prev = head;
    const curr = head.next;
    while (curr != null && curr.key != key) {
      prev = curr;
      curr = curr.next;
    }
    return prev;
  };
}
