// Did this code successfully run on Leetcode : yes
/**
 * Any problem you faced while coding this : 
 * 1. Initially stuctured the code as List<Node> buckets; Later structured as List<Bucket> buckets => Bucket = head of Node
 * 2. Didn't initialize the dynamic array to a specific size, hence OutOfBoundsException
 * 3. analyzing the worst-case TC
 */

// Your code here along with comments explaining your approach
/**
 * Constraints:
 * 1. Implement map of integers i.e. Map<Integer, Integer>
 * 2. Keys are always unique
 * 
 * Functions:
 * 1. int get(int key) => if key exists, Get the value associated to the key;
 * else return -1
 * 2. void put(int key, int value) => if key already exists, overwrite the
 * value; else Put the key-value pair in the map
 * 3. void remove(int key) => if key exists, remove the key-value pair
 * associated
 * to the key
 * 
 * Algorithm:
 * 1. Use a Bucket object to refer to a key-value pair
 * 2. Use a Dynamic Array to back your HashMap i.e. to store the Bucket(s)
 * 3. Implement a hash() on the key to get the offset(index) of the key in
 * the dynamic array
 * 4. Handle Collision: Maintain a Singly Linked List of Bucket(s) for keys
 * mapping to the same offset
 * 
 * TC:
 * k = size
 * n = maximum value
 * get() = amortized O(1); worst O(n/k) eg: if at max 10^6 values, available buckets = 10^3 => per bucket = 10^3 values; NOTE: we can always have unique keys (since we're implementing Hashing)
 * put() = amortized O(1); worst O(n/k)
 * remove() = amortized O(1); worst O(n/k)
 * 
 * SC:
 * get() = O(1)
 * put() = O(n)
 * remove() = O(1)
 */
import java.util.ArrayList;
import java.util.List;

public class HashMap {

    /**
     * HashMap with Linear Chaining
     */

    private static final int SIZE = 1031;
    private List<Bucket> buckets;

    public HashMap() {
        buckets = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            buckets.add(new Bucket());
        }
    }

    private class Bucket {
        private Node head;

        private class Node {
            int key;
            int value;
            Node next;

            Node() {

            }

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Bucket() {
            // head = new Node();
        }

        /**
         * Find a node in a Singly Linked List
         * 
         * @param key
         * @return
         */
        private Node get(int key) {
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    break;
                }
                curr = curr.next;
            }
            return curr;
        }

        /**
         * Add node to the head of the Singly Linked List
         * 
         * @param key
         */
        private void add(int key, int value) {
            Node node = get(key);
            if (node != null) {
                node.value = value;
                return;
            }
            node = new Node(key, value);
            node.next = head;
            head = node;
        }

        /**
         * Remove a node from a singly Linked List
         * 
         * @param key
         */
        private void remove(int key) {
            // traverse the Linked List to get the bucket associated to the key
            Node dummy = new Node();
            dummy.next = head;

            Node curr = head;
            Node prev = dummy;

            while (curr != null) {
                // if key found
                if (curr.key == key) {
                    prev.next = curr.next;
                    // remove the bucket from the Linked List
                    curr.next = null;
                    break;
                }
                // store the previous bucket
                prev = curr;
                curr = curr.next;
            }

            head = dummy.next;
        }

    }

    // allocate a bucket to this key
    private int hash(int key) {
        return key % SIZE;
    }

    public int get(int key) {
        // fetch the Bucket
        int hashCode = hash(key);
        Bucket bucket = buckets.get(hashCode);
        Bucket.Node node = bucket.get(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        // fetch the Bucket
        int hashCode = hash(key);
        Bucket bucket = buckets.get(hashCode);
        bucket.add(key, value);
    }

    public void remove(int key) {
        // fetch the Bucket
        int hashCode = hash(key);
        Bucket bucket = buckets.get(hashCode);
        bucket.remove(key);
    }

}