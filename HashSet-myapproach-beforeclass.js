// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class HashSet {
  // initialised items
  constructor() {
    this.items = [];
  }

  // check if element is present
  contains = (key) => {
    // using array find function we can do in the below way
    // return this.items.find((i) => i === key);
    // without using array find function
    let isPresent = false;
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i] === key) {
        // checking if element matches any of the items
        isPresent = true;
        break; // if present we are breaking the loop, so that unncessary looping will not happen
      }
      continue;
    }
    return isPresent;
  };

  // adds element to the set
  add = (key) => {
    if (!this.contains(key)) {
      this.items = [...this.items, key];
    }
    return this.items;
  };

  remove = (key) => {
    if (this.contains(key)) {
      this.items = this.items.filter((i) => i !== key);
    }
    return this.items;
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
