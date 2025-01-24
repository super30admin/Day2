// TC: put, get, remove - O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//* WITH DOUBLE HASHING */

// class MyHashMap {

//     boolean[][] hashMapK;
//     int[][] hashMapV;
//     int horL;
//     int verL;

//     int hash1(int key){
//         return key % horL;
//     }

//     int hash2(int key){
//         return key / verL;
//     }

//     public MyHashMap() {
//         horL = 1000;
//         verL = 1000;
//         hashMapK = new boolean[horL][];
//         hashMapV = new int[horL][];
//     }

//     public void put(int key, int value) {
//         int hInd = hash1(key);
//         if(hashMapK[hInd] == null){
//             if(hInd == 0){
//                 hashMapK[hInd] = new boolean[verL+1];
//                 hashMapV[hInd] = new int[verL+1];
//             }
//             else{
//                 hashMapK[hInd] = new boolean[verL];
//                 hashMapV[hInd] = new int[verL];
//             }
//         }
//         int vInd = hash2(key);
//         hashMapK[hInd][vInd] = true;
//         hashMapV[hInd][vInd] = value;
//     }

//     public int get(int key) {
//         int hInd = hash1(key);
//         if(hashMapK[hInd] == null)
//             return -1;
//         int vInd = hash2(key);
//         return hashMapK[hInd][vInd] ? hashMapV[hInd][vInd] : -1;
//     }

//     public void remove(int key) {
//         int hInd = hash1(key);
//         if(hashMapK[hInd] != null){
//             int vInd = hash2(key);
//             hashMapK[hInd][vInd] = false;
//             hashMapV[hInd][vInd] = -1;
//         }
//     }
// }

//* WITH LINEAR CHAINING */

class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;

        public Node(int k, int v){
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }

    Node[] primary;

    public MyHashMap() {
        primary = new Node[10000];
    }

    int hash1(int key){
        return key % 10000;
    }

    public Node searchKey(Node head, int key){
        Node prev = head;
        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int ind = hash1(key);
        if(primary[ind] == null)
            primary[ind] = new Node(-1, -1);
        Node prev = searchKey(primary[ind], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }

    public int get(int key) {
        int ind = hash1(key);
        if(primary[ind] == null)
            return -1;
        Node prev = searchKey(primary[ind], key);
        if(prev.next != null)
            return prev.next.value;
        return -1;
    }

    public void remove(int key) {
        int ind = hash1(key);
        System.out.println(key);
        if(primary[ind] != null){
            Node prev = searchKey(primary[ind], key);
            if(prev.next != null){
                Node temp = prev.next;
                prev.next = temp.next;
                temp.next = null;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */