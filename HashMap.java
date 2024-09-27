//I implemented the HashMap using linkedlist which is spearate chaining. Hashmap is a key value pair datastructure, therefore, I need to have my node structure with key value and address. Inserting at the front of the linkedlist would have been helpful since it was performing insertion in constant time, but this kind of insertion does not work while updating the values, therefore, we initially perform the finding of that node. 
//Special attention needs to be taken into account while considering the edge case of removing the first elemement of the linkedlist. 



class MyHashMap {
    
    class Node {
    int key;
    int value;
    Node next;
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
    }
    
    Node[] linkedL;
    
    public MyHashMap() {
        linkedL = new Node[10000];
    }
    
    private Node find(Node head, int key)
    {
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev; 
    }
    
    private int hashingFunction(int key)
    {
        return key%10000;
    }
    
    public void put(int key, int value) {
        int index = hashingFunction(key);
        if (linkedL[index] == null)
        {
            linkedL[index] = new Node(-1,-1);            
        }

            Node temp = find(linkedL[index], key);
        
            if (temp.next == null)
            {
            Node newnode = new Node(key, value);
            temp.next = newnode;
            }
            else
            {
            temp.next.value = value;
            }
    }