package com;
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
/**
 * Implement hashset(add only unique elements) using array of ListNode
 */
public class MyHashSet {
    ListNode[] arrayOfListNode;

    class ListNode{
        int key;
        ListNode next;

        /**
         * ListNode Constructor
         * @param key
         */
        ListNode(int key){
            this.key=key;
            next=null;
        }
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        arrayOfListNode=new ListNode[10000];
    }

    //Time complexity:o(1). In worst case it will be 0(n)
    //Space complexity:o(1)
    /**
     * Add the key in set. If it the key already exists then dont add
     * @param key: integer key to be added in set
     */
    public void add(int key) {
        if(contains(key))
            return;
        int bucketId= getBucket(key);
        ListNode head=arrayOfListNode[bucketId];

        ListNode newNode=new ListNode(key);
        if(head==null){
            arrayOfListNode[bucketId]=newNode;
        }else{
            ListNode prev=findPrevNode(head,key);
            prev.next=newNode;
        }

    }
    //Time complexity:o(1). In worst case it will be 0(n)
    //Space complexity:o(1)

    /**
     * check if key is available in map, if exists then remove it else do nothing
     * @param key key to be removed from set
     */
    public void remove(int key) {
        if(!contains(key))
            return;
        int bucketId= getBucket(key);
        ListNode head=arrayOfListNode[bucketId];

        //when the first element is the elemnt to be removed;
        if(head.key==key){
            arrayOfListNode[bucketId]=head.next;

        }else{
            ListNode prev=findPrevNode(head,key);
            if(prev.next!=null)
                prev.next=prev.next.next;
        }

    }

    /**
     * This is the hash function to get a bucket number from the array for given key
     * @param key: key to be hashed to find bucket/index in array
     * @return index/bucket id
     */
    private int getBucket(int key){
        return key%arrayOfListNode.length;
    }

    //Time complexity:o(1). In worst case it will be 0(n)
    //Space complexity:o(1)
    /**
     * Returns true if this set contains the specified element
     * @param key check for this key in set
     * @return return true if key exists in set else return false
     */
    public boolean contains(int key) {
        int bucketId= getBucket(key);
        ListNode head=arrayOfListNode[bucketId];
        if(head==null)
            return false;
        else{
            if(head.key==key)
                return true;
            else{
                ListNode prev=findPrevNode(head,key);
                if(prev.next==null)
                    return false;
                else
                    return true;
            }
        }

    }

    private ListNode findPrevNode(ListNode head,int key){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            if(curr.key==key)
                return prev;
            else{
                prev=curr;
                curr=curr.next;
            }
        }
        return prev;

    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}