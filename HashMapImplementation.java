import java.util.LinkedList;

class MyHashMap {
    class ListNode {
        int key;
        int value;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int k = 100007;
    LinkedList<ListNode>[] map;

    public MyHashMap() {
        map = new LinkedList[k];
    }

    public void put(int key, int value) {
        int hash = key % k;
        boolean isPresent = false;
        LinkedList<ListNode> q = map[hash] == null ? new LinkedList() : map[hash];
        for (ListNode node : q) {
            if (node.key == key) {
                isPresent = true;
                node.value = value;
                break;
            }
        }
        if (!isPresent) {
            q.add(new ListNode(key, value));
            map[hash] = q;
        }
    }

    public int get(int key) {
        int hash = key % k;
        if (map[hash] == null || map[hash].isEmpty()) {
            return -1;
        }
        for (ListNode node : map[hash]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key % k;
        if (map[hash] == null || map[hash].isEmpty()) {
            return;
        }
        for (ListNode node : map[hash]) {
            if (node.key == key) {
                map[hash].remove(node);
            }
        }
    }
}
