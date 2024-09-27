
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : dealt with 2d array

// Your code here along with comments explaining your approach
/*
for 1million inputs used a 1000*1001 array initialized only when needed. this covers 1million value case
used 2 hash functions (double hashing)
while pushing if array not initialized then initialize it at that particular index and put value
no need to store actual value as key corresponds to value
*/
package main

import "fmt"

const (
	BucketSize = 1000
	BucketItemSize = 1001
)
type MyHashSet struct {
	Set [][]bool
}


/** Initialize your data structure here. */
func Constructor() MyHashSet {
	var x MyHashSet
	x.Set = make([][]bool, BucketSize)
	return x
}

func hash1(val int) int {
	return val % BucketSize
}
func hash2(val int) int {
	return val / BucketSize
}

func (this *MyHashSet) Add(key int)  {
	ind1 := hash1(key)
	ind2 := hash2(key)
	if this.Set[ind1] == nil {
		this.Set[ind1] = make([]bool, BucketItemSize)
	}
	this.Set[ind1][ind2] = true
}


func (this *MyHashSet) Remove(key int)  {
	ind1 := hash1(key)
	ind2 := hash2(key)
	if this.Set[ind1] == nil { return }
	this.Set[ind1][ind2] = false
}


/** Returns true if this set contains the specified element */
func (this *MyHashSet) Contains(key int) bool {
	ind1 := hash1(key)
	ind2 := hash2(key)
	if this.Set[ind1] == nil {
		this.Set[ind1] = make([]bool, BucketItemSize)
	}
	return this.Set[ind1][ind2]
}

func MainHashSet() {
	hashSet := Constructor()
	hashSet.Add(1)
	hashSet.Add(2)
	fmt.Println(hashSet.Contains(1))  // returns true
	fmt.Println(hashSet.Contains(3))    // returns false (not found)
	hashSet.Add(2)
	fmt.Println(hashSet.Contains(2))    // returns true
	hashSet.Remove(2)
	fmt.Println(hashSet.Contains(2))    // returns false (already removed)
}
