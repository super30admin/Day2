
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// ***********  USING DOUBLE HASHING *************

var MyHashSet = function() {
  this.hashSet = new Array(1000).fill('null')
  this.bucket = 1000;
  this.bucketItems = 1000; // In this example square root of 10 to the power 6 is 1000, it might change based on data given
};

MyHashSet.prototype.hash1 = function(key) {
  // To find the primary array index
  return key % this.bucket;
}

MyHashSet.prototype.hash2 = function(key) {
  // To find the secondary array index (offset)
  return Math.floor(key / this.bucketItems);
}

/** 
* @param {number} key
* @return {void}
*/
MyHashSet.prototype.add = function(key) {
  let bucket = this.hash1(key);
  let bucketItem = this.hash2(key);
  if (this.hashSet[bucket] === 'null') {
      if (bucket === 0) {
          this.hashSet[bucket]= new Array(this.bucketItems + 1).fill(false);
      } else {
          this.hashSet[bucket] = new Array(this.bucketItems).fill(false);
      }
  }
  
  this.hashSet[bucket][bucketItem]=true;
};

/** 
* @param {number} key
* @return {void}
*/
MyHashSet.prototype.remove = function(key) {
  let bucket = this.hash1(key);
  let bucketItem = this.hash2(key);
  
  if (this.hashSet[bucket] !== 'null') {
      this.hashSet[bucket][bucketItem] = false;
  }
};

/** 
* @param {number} key
* @return {boolean}
*/
MyHashSet.prototype.contains = function(key) {
  let bucket = this.hash1(key);
  let bucketItem = this.hash2(key);
  return this.hashSet[bucket] !== 'null' && this.hashSet[bucket][bucketItem];
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

// --------------------------------------------------------------------------------------------------------------

// *********** MY EARLIER APPROACH *************
var MyHashSet = function() {
    this.hashSet = {}
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
    if (!this.hashSet[key]) {
      this.hashSet[key] = true;
    }
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {

    if (this.hashSet[key]) {
      delete this.hashSet[key];
    }
};

/** 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
    if (this.hashSet[key]) { 
      return true; 
    } else {
      return false;
    }
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */