// In this implementation, the bucket class handles most of the operations. 
// Each bucket has a container which is in the form of a linkedlist, and all the new elements which fall into this bucket are added in that linkedlist
// for the main implementation of the set, I have created an array of buckets, and when user need to add an element to the 
// set, the bucket to which the input element need to be inserted is determined by calculating the hash value. 

// Time Complexity : O(1) for add, O(n) for remove and exists operation 
// Space Complextiy : O(1) as no additional space is being used apart from space to store the input elements

import java.util.LinkedList;

public class MyHashSet1 {

    private class Bucket {
        private LinkedList<Integer> containers;

        public Bucket() {
            containers = new LinkedList<>();
        }

        public void insert(Integer key) {
            int index = containers.indexOf(key);
            if (index == -1) {
                containers.addFirst(key);
            }
        }

        public void delete(Integer key) {
            containers.remove(key);
        }

        public boolean exists(Integer key) {
            int index = containers.indexOf(key);
            return index != -1;
        }
    }

    private Bucket[] bucketArray;
    private int keyrange;

    public MyHashSet1() {
        keyrange = 2069;
        bucketArray = new Bucket[keyrange];

        for (int i = 0; i < keyrange; i++) {
            bucketArray[i] = new Bucket();
        }
    }

    public void add(int key) {
        int index = key % bucketArray.length;
        bucketArray[index].insert(key);
    }

    public void remove(int key) {
        int index = key % bucketArray.length;
        bucketArray[index].delete(key);
    }

    public boolean contains(int key) {
        int index = key % bucketArray.length;
        return bucketArray[index].exists(key);
    }

    public static void main(String[] args) {
        MyHashSet1 set1 = new MyHashSet1();
        set1.add(12);
        set1.add(25);
        set1.add(30);

        set1.remove(12);
        if (set1.contains(25)) {
            System.out.println("Element exist");
        } else {
            System.out.println("Element does not exist");
        }

        if (set1.contains(35)) {
            System.out.println("Element exist");
        } else {
            System.out.println("Element does not exist");
        }
    }
}