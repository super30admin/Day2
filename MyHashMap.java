
// Time Complexity :  O(1) average and O(n) worst case - for all get(),put() and remove() methods.
// Space Complexity : O(n) - where n is the number of entries in HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, Couldn't run the code using seperate chaingin as  explained in class, hence did this way

class MyHashMap {

    public MyHashMap() {

    }

    ListNode[] nodes = new ListNode[10000];

    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.val;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
    }

    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if (prev.next != null)
            prev.next = prev.next.next;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findElement(int index, int key) {
        if (nodes[index] == null)
            return nodes[index] = new ListNode(-1, -1);
        ListNode prev = nodes[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    private static class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyHashMap mp = new MyHashMap();
        mp.put(1, 1);
        mp.put(2, 2);
        System.out.println(mp.get(1));
        System.out.println(mp.get(3));
        System.out.println(mp.get(2));
        mp.put(2, 1);
        System.out.println(mp.get(2));
        mp.remove(2);
        System.out.println(mp.get(2));
    }
}
