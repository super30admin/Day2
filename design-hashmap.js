
var MyHashMap = function() {
    this.buckets = 1000; //using this number since input is betwen 0 and 10^6
    this.map = new Array(this.buckets).fill(null).map(() => []);
};

/** 
 * Hash function to get an index for a key
 * @param {number} key 
 * @return {number}
 */
MyHashMap.prototype.hash = function(key) {
    return key % this.buckets;
}

MyHashMap.prototype.getPrev = function(head, key){
    let prev = null;
    let curr = head;

    while(curr !== null && curr.ket !== key) {
        prev = curr;
        curr = curr.next;
    }
    return prev;
}


/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
    const idx = this.hash(key);
    const bucket = this.map[idx];

    // Check if the key exists and update it if found
    for (let i = 0; i < bucket.length; i++) {
        if (bucket[i][0] === key) {
            bucket[i][1] = value;
            return;
        }
    }

    // If key doesn't exist, push a new (key, value) pair
    bucket.push([key, value]);
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
     const idx = this.hash(key);
    const bucket = this.map[idx];

    // Search for the key in the bucket
    for (let i = 0; i < bucket.length; i++) {
        if (bucket[i][0] === key) {
            return bucket[i][1];
        }
    }

    return -1; // Key not found
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    const idx = this.hash(key);
    const bucket = this.map[idx];

    // Find the key and remove the entry
    for (let i = 0; i < bucket.length; i++) {
        if (bucket[i][0] === key) {
            bucket.splice(i, 1);
            return;
        }
    }
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */