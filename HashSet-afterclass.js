// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Unable to use data types since js is not typed-language. I will try to use typescript next time.

// we are considering input between the range [1-10^6]
class HashSet {
  // initialised items

  constructor() {
    this.buckets = 1000;
    this.bucketItems = 1000;
    this.storage = new Array(this.buckets);
  }

  getBucket = (key) => {
    return key % this.buckets;
  };

  getBucketItem = (key) => {
    return key / this.bucketItems;
  };

  // adds element to the set
  add = (key) => {
    const bucket = this.getBucket(key);
    const bucketItem = this.getBucketItem(key);
    if (this.storage[bucket] == null) {
      if (bucket == 0) {
        this.storage[bucket] = new Array(this.bucketItem + 1);
      } else {
        this.storage[bucket] = new Array(this.bucketItems);
      }
    }
    this.storage[bucket][bucketItem] = true;
    return this.storage;
  };

  // check if element is present
  contains = (key) => {
    const bucket = this.getBucket(key);
    const bucketItem = this.getBucketItem(key);
    if (this.storage[bucket] == null) {
      return false;
    }
    return this.storage[bucket][bucketItem];
  };

  remove = (key) => {
    const bucket = this.getBucket(key);
    const bucketItem = this.getBucketItem(key);
    if (this.storage[bucket] === null) {
      return;
    }
    this.storage[bucket][bucketItem] = false;
  };
}

// using object
// class HashSet {
//   constructor() {
//     this.hs = {};
//   }

//   add = (key) => {
//     if (!this.hs[key]) {
//       this.hs[key] = true;
//     }
//   };

//   remove(key) {
//     if (this.hs[key]) {
//       delete this.hs[key];
//     }
//   }

//   contains(key) {
//     return this.hs[key] || false;
//   }
// }

myHashSet = new HashSet();
console.log("add 1", myHashSet.add(1));
console.log("add 1", myHashSet.add(1));
console.log("add 1", myHashSet.add(1));
console.log("add 2", myHashSet.add(2));
console.log("add 3", myHashSet.add(3));
console.log("add 4", myHashSet.add(4));
console.log("contains 4", myHashSet.contains(4));
console.log("remove 4", myHashSet.remove(4));
console.log("contains 10", myHashSet.contains(10));
