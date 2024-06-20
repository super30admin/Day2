/*
Time Complexity:
    1. Put : 0(n)
    2. Get: 0(n)
    3. Remove: 0(n)
Space Complexity: 0(n)
Run On LeetCode: Yes
Approach: Used approach of chaning using linked-list. Created a primary array which will store a
LinkedList at every index. Inside the LinkedList we will strore the object of class Node.
 */

import java.util.Iterator;
import java.util.LinkedList;


class Node{
    public int key;
    public int value;

    public Node(int k, int v){
        this.key = k;
        this.value = v;
    }
}

class MyHashMap {

    private LinkedList<Node> [] primaryArray;
    private int size;

    public MyHashMap() {
        this.size = 1000;
        this.primaryArray = new LinkedList[this.size];
    }

    // hashfunction
    private int hashFunction1(int key){
        return key%this.size;
    }

//    private void printLinkedList(int idx){
//
//        LinkedList<Node> ll = this.primaryArray[idx];
//        Iterator<Node> itr = ll.iterator();
//
//        System.out.println("Linked List at idx = " + idx);
//
//        while(itr.hasNext()){
//            Node objNode = itr.next();
//            System.out.println("key = " + objNode.key + " value = "+objNode.value);
//        }
//
//        System.out.println("end ***\n");
//    }

    public void put(int key, int value) {

        int idx = this.hashFunction1(key);

        // chk if idx is empty or not
        if (this.primaryArray[idx] == null){
            // create an object of class linked list
            LinkedList<Node> linkedList = new LinkedList<Node>();
            this.primaryArray[idx] = linkedList;
        }

        // get linkedList object
        LinkedList<Node> linkedList = this.primaryArray[idx];

        // chk if key is inside linkedList, so iterate the linkedList
        Iterator<Node> itr = linkedList.iterator();

        while(itr.hasNext()){
            Node nodeObj = itr.next();

            if (nodeObj.key == key){
                // found key, update the value
                nodeObj.value = value;

//                // just print the linkedList
//                this.printLinkedList(idx);

                return; // return from here
            }
        }

        // didn't find the key, create a node and add inside the linkedList
        Node objNewNode = new Node(key, value);
        linkedList.add(objNewNode);

        // just print the linkedList
//        this.printLinkedList(idx);

        return;

    }
    
    public int get(int key) {

        // get idx
        int idx = this.hashFunction1(key);

        // base case
        if (this.primaryArray[idx] == null){
            return -1;
        }

        // get the object of linkedList, initialize the iterator and iterate the linkedList
        LinkedList<Node> linkedList = this.primaryArray[idx];
        Iterator<Node> itr = linkedList.iterator();

        while(itr.hasNext()){
            Node objNode = itr.next();

            if (objNode.key == key){
                return objNode.value;
            }
        }

        // no key inside the linkedList
        return -1;

    }

    public void remove(int key) {

        // get idx
        int idx = this.hashFunction1(key);

        // base case
        if (this.primaryArray[idx] == null){
            return ;
        }

        LinkedList<Node> linkedList = this.primaryArray[idx];
        Iterator<Node> itr = linkedList.iterator();

        while(itr.hasNext()){

            Node objNode = itr.next();

            if (objNode.key == key){
                // remove this node from the linkedList
                linkedList.remove(objNode);
                break;
            }
        }

        // print the linkedlist after removal
//        System.out.println("Linked List after remove function call...");
//        this.printLinkedList(idx);

        return;
    }
}
