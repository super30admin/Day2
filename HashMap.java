/*
    1. Time Complexity : For operations add, remove, contains - O(1)
    2. Space Complexity : O(n)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * HashMap with Double Hashing
 * For the given data range [0, 10^6], created array of 10^3 + 1 buckets
 * 10^3 buckets for [0,999999] and additional bucket of size 1 just for key 10^6
 * Each bucket points to an array of size 10^3. 
 * One hash function (key / 10^3) gives the bucket index;
 * Second has function (key % 10^3) gives the bucketItem index. 
 */

import java.util.Arrays;

class CustomHashMap {
    private int[][] arr;
    private int buckets = 1000;
    private int bucketItems = 1000;

    public CustomHashMap() {
        arr = new int[buckets+1][];
    }
    private int bucketHash(int key) {
        return key / buckets;
    } 
    private int bucketItemHash(int key) {
        return key % bucketItems;
    }
    public void put(int key, int value) {
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        if (arr[bucket] == null) {
            arr[bucket] = (bucket == 1000) ? new int[1] : new int[bucketItems];
            Arrays.fill(arr[bucket], -1);
        }
        arr[bucket][bucketItem] = value;
    }

    public int get(int key) {
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        if (arr[bucket] == null) return -1;
        return (arr[bucket][bucketItem] == -1) ? -1 : arr[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        if (arr[bucket] == null) return;
        arr[bucket][bucketItem] = -1;
    }
}

/*
 * HashMap with Linear Chaining
 * For the given data range [0, 10^6], created array of 10^4 buckets.
 * Each bucket is a linked list.
 */

class HashMapWithLinearChaining {
    int buckets = 10000;
    Node[] arr;
    class Node {
        int key;
        int data;
        Node next;
        Node(int key, int data, Node next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }
    }

    public HashMapWithLinearChaining() {
        arr = new Node[buckets];
        Arrays.fill(arr, null);
    }
    public int hash(int key) {
        return key % 10000;
    }
    public void put(int key, int value) {
        int bucket = hash(key);
        Node curr = search(key);
        if (curr != null) {
            curr.data = value;
        } else {
            arr[bucket] = new Node(key, value, arr[bucket]);
        }
    }
    public Node search(int key) {
        Node curr = arr[hash(key)];
        while (curr != null) {
            if (curr.key == key) return curr;
            curr = curr.next;
        }
        return null;
    }

    public int get(int key) {
        Node curr = search(key);
        return (curr == null) ? -1 : curr.data;
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        Node curr = arr[bucket], prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null)
                    arr[bucket] = arr[bucket].next;
                else
                    prev.next = curr.next;
                curr.next = null;
                return;
            }
            prev = curr;
            curr = curr.next;
        } 
    }
}

class Solution {
    public static void main(String[] args) {
        CustomHashMap map =  new CustomHashMap();
        map.put(1, 1);
        map.put(2, 5);
        map.put(0, 100);
        System.out.println(map.get(1));
        System.out.println(map.get(0));
        map.put(1000000, 1000000);
        map.remove(0);
        System.out.println(map.get(0));
        System.out.println(map.get(1000000));

        HashMapWithLinearChaining map2 = new HashMapWithLinearChaining();
        map2.put(0, 1000000);
        map2.put(1000000, 0);
        map2.put(999999, 1);
        System.out.println(map2.get(1000000));
        map2.remove(1000000);
        System.out.println(map2.get(1000000));
        System.out.println(map2.get(0));
    }
}

