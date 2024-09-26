// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class MyHashMap {
    private final int BUCKET_SIZE = 10_000;

    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node [] arr;



    private int getKey(int key){
        return key/BUCKET_SIZE;
    }

    public MyHashMap() {
        arr = new Node[BUCKET_SIZE];
    }

    public void put(int key, int value) {

        int hashKey = this.getKey(key);

        if (arr[hashKey] == null){
            Node head = new Node(-1,-1);
            arr[hashKey] = head;
        }
        Node prev = arr[hashKey];
        Node current = prev.next;

        while(current != null && prev.next != null){
            if (current.key == key){
                current.value  = value;
                return;
            }
            prev = current;
            current = current.next;
        }
        prev.next = new Node(key,value);




    }

    public int get(int key) {
        int hashKey = this.getKey(key);
        if (arr[hashKey] != null) {
            Node prev = arr[hashKey];
            Node current = prev.next;

            while(current != null && prev.next != null) {
                if (current.key == key) {
                    return current.value;
                }
                prev = current;
                current = current.next;
            }
        }
        return -1;
    }

    public void remove(int key) {

        int hashKey = this.getKey(key);
        if (arr[hashKey] != null) {
            Node prev = arr[hashKey];
            Node current = prev.next;

            while(current != null && prev.next != null) {
                if (current.key == key) {
                    prev.next = prev.next.next;
                    return;
                }
                prev = current;
                current = current.next;
            }
        }
    }

    public static void main(String [] args){
                MyHashMap obj = new MyHashMap();
                obj.put(0, 0);
                obj.put(1, 10);
                obj.put(1, 20);
                obj.put(2, 20);

                System.out.println(obj.get(1));
                obj.remove(1);
                System.out.println(obj.get(1));
                obj.put(1, 30);
                System.out.println(obj.get(1));

    }


}


