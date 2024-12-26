// Time Complexity: O(n) as the traversing to find a previous/current Node takes linear time
// Space Complexity: O(1).

class Node {
    int key;
    int val;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {
    int bucketNumber;
    Node bucketStorageNode[];

    public MyHashMap() {
        this.bucketNumber = 1000;
        this.bucketStorageNode = new Node[bucketNumber];
    }

    int getBucketNumber(int key) {
        return Integer.hashCode(key) % bucketNumber;
    }

    Node find(Node dummy, int key) {
        Node previousNode = dummy;
        Node currentNode = previousNode.next;
        while (currentNode != null && currentNode.key != key) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return previousNode;
    }

    public void put(int key, int value) {
        int bucketNo = getBucketNumber(key);
        if (bucketStorageNode[bucketNo] == null) {
            bucketStorageNode[bucketNo] = new Node(-1, -1);
        }
        Node previousNode = find(bucketStorageNode[bucketNo], key);
        if (previousNode.next != null) {
            previousNode.next.val = value;
        } else {
            previousNode.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int bucketNo = getBucketNumber(key);
        if (bucketStorageNode[bucketNo] == null) {
            return -1;
        }
        Node previousNode = find(bucketStorageNode[bucketNo], key);
        if (previousNode.next != null) {
            return previousNode.next.val;
        }
        return -1;
    }

    public void remove(int key) {
        int bucketNo = getBucketNumber(key);
        if (bucketStorageNode[bucketNo] == null) {
            return;
        }
        Node previousNode = find(bucketStorageNode[bucketNo], key);
        if (previousNode.next != null) {
            previousNode.next.val = -1;
        }
    }
}

public class HashMap {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2, 1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}
