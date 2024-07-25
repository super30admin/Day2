// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
var MyHashMap = function() {
    this.obj = new Array(1000001)
  };
  
  /** 
   * @param {number} key 
   * @param {number} value
   * @return {void}
   */
  MyHashMap.prototype.put = function(key, value) {
      this.obj[key] = value
  };
  
  /** 
   * @param {number} key
   * @return {number}
   */
  MyHashMap.prototype.get = function(key) {
      let res = this.obj[key]
      return res !== undefined ? res : -1
  };
  
  /** 
   * @param {number} key
   * @return {void}
   */
  MyHashMap.prototype.remove = function(key) {
      delete this.obj[key]
  };
  
  /** 
   * Your MyHashMap object will be instantiated and called as such:
   * var obj = new MyHashMap()
   * obj.put(key,value)
   * var param_2 = obj.get(key)
   * obj.remove(key)
   */