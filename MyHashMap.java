// Approach: An array of linkedlists of size 1000 is used as buckets to store list nodes holding KV pairs.
// Each key is hashed using mod operation to obtain the bucket index. If key is already present in the
// linkedlist at the bucket index, its associated value is updated. Otherwise, a new node is added to the Linkedlist.
// Time Complexity : O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
@SuppressWarnings("unchecked")
public class MyHashMap {
    LinkedList<ListNode>[] listArr;

    class ListNode {
        int key, val;

        ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    MyHashMap() {
        listArr = new LinkedList[1000];
        for (int i = 0; i < 1000; i++) {
            listArr[i] = new LinkedList<>();
        }
    }

    int hash(int key) {
        return key % 1000;
    }

    int get(int key) {
        int bucketIdx = hash(key);
        LinkedList<ListNode> list = listArr[bucketIdx];
        for (ListNode ln : list) {
            if (ln.key == key) {
                return ln.val;
            }
        }
        return -1;
    }

    void put(int key, int val) {
        int bucketIdx = hash(key);
        LinkedList<ListNode> list = listArr[bucketIdx];
        for (ListNode ln : list) {
            if (ln.key == key) {
                ln.val = val;
                return;
            }
        }
        list.add(new ListNode(key, val));
    }

    void remove(int key) {
        int bucketIdx = hash(key);
        LinkedList<ListNode> list = listArr[bucketIdx];
        int keyIdx = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                keyIdx = i;
                break;
            }
        }
        if (keyIdx == -1) {
            return;
        }
        list.remove(keyIdx);
    }

    void printHashMapContents() {
        for (int i = 0; i < 1000; i++) {
            LinkedList<ListNode> list = listArr[i];
            for (ListNode ln : list) {
                System.out.println("key: " + ln.key + " val: " + ln.val);
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();

        hm.put(10, 5);
        System.out.println("HashMap contents after putting key 10..");
        hm.printHashMapContents();
        hm.put(20, 10);
        System.out.println("HashMap contents after putting key 20..");
        hm.printHashMapContents();
        hm.put(30, 15);
        System.out.println("HashMap contents after putting key 30..");
        hm.printHashMapContents();

        System.out.println("Value associated with key 20 is: " + hm.get(20));
        hm.put(20, 40);
        System.out.println("Value associated with key 20 after updating via put operation: " + hm.get(20));

        hm.remove(10);
        System.out.println("HashMap contents after removing key 10..");
        hm.printHashMapContents();
        hm.remove(10);
        System.out.println("HashMap contents after removing key 10 again..");
        hm.printHashMapContents();
    }
}