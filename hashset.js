var MyHashSet = function() {
  return Object.assign(Object.create(MyHashSet.prototype), {
    hash: Array(16).fill([]),
    hashSize: 16,
  })
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
  const hindex = key % this.hashSize
  const findex = this.hash[hindex].findIndex(k => k === key)/*?*/
  if (findex > -1) return
  this.hash[hindex] = this.hash[hindex].concat(key)/*?*/
};
// mhs = MyHashSet()/*?*/
// mhs.add(2)
// mhs.add(2)
// mhs

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
  const hindex = key % this.hashSize
  const findex = this.hash[hindex].findIndex(k => k === key)
  if (findex < 0)
    return
  this.hash[hindex] = this.hash[hindex].filter(k => k !== key)
};

/**
 * Returns true if this set contains the specified element
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
  return this.hash[key % this.hashSize].find(k => k === key) != null
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
