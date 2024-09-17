var MyHashMap = function () {
    this.nodes = new Array(100000);
  };
  
  MyHashMap.prototype.getHash = function (key) {
    return key % 100000;
  };
  //Time : O(1)
  MyHashMap.prototype.put = function (key, value) {
    const hash = this.getHash(key);
    let node = this.nodes[hash];
    if (!node) {
      this.nodes[hash] = { key, value };
      return;
    }
    while (node) {
      if (node.key === key) {
        node.value = value;
        return;
      }
      if (!node.next) {
        node.next = { key, value };
        return;
      }
      node = node.next;
    }
  };
   //Time : O(1)
  MyHashMap.prototype.get = function (key) {
    const hash = this.getHash(key);
    let node = this.nodes[hash];
    if (!node) {
      return -1;
    }
    while (node) {
      if (node.key === key) {
        return node.value;
      }
      node = node.next;
    }
    return -1;
  };
   //Time : O(1)
  MyHashMap.prototype.remove = function (key) {
    const hash = this.getHash(key);
    let node = this.nodes[hash];
    if (!node) {
      return;
    }
    const head = { next: node };
    node = head;
    while (node.next) {
      if (node.next.key === key) {
        node.next = node.next.next;
      }
    }
    this.nodes[hash] = head.next;
  };
  