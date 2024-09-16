// Time Complexity :    O(1) for all operations
// Space Complexity :   O(n)
// Yes, It's run successfully
// No I don't face any problem.



public class DesignHashSet705LeetCode {

    public static void main(String[] args) {

//        MyHashSet1 myHashSet = new MyHashSet1();
//        myHashSet.add(1);   // set = [1]
//        myHashSet.add(2);      // set = [1, 2]
//        //myHashSet.contains(1); // return True
//        System.out.println(myHashSet.contains(1));
//        System.out.println(myHashSet.contains(3)); // return False, (not found)
//        myHashSet.add(2);      // set = [1, 2]
//        //myHashSet.contains(2); // return True
//        System.out.println(myHashSet.contains(2));
//        myHashSet.remove(2);   // set = [1]
//        //myHashSet.contains(2); // return False, (already removed)
//        System.out.println(myHashSet.contains(2));
//        myHashSet.add(2);      // set = [1, 2]
//        //myHashSet.contains(2); // return True
//        System.out.println(myHashSet.contains(2));
//

        MyHashSet2 myHashSet2 = new MyHashSet2();
        myHashSet2.add(1);   // set = [1]
        myHashSet2.add(2);      // set = [1, 2]
        //myHashSet2.contains(1); // return True
        System.out.println(myHashSet2.contains(1));
        System.out.println(myHashSet2.contains(3)); // return False, (not found)
        myHashSet2.add(2);      // set = [1, 2]
        //myHashSet2.contains(2); // return True
        System.out.println(myHashSet2.contains(2));
        myHashSet2.remove(2);   // set = [1]
        //myHashSet2.contains(2); // return False, (already removed)
        System.out.println(myHashSet2.contains(2));
        myHashSet2.add(2);      // set = [1, 2]
        //myHashSet.contains(2); // return True
        System.out.println(myHashSet2.contains(2));

    }
}


class MyHashSet2 {

    boolean[][] hashSet;
    int hash1 = 1000;
    int hash2 = 1000;

    int getHash1(int key){
        return key%hash1;
    }

    int getHash2(int key){
        return key/hash2;
    }

    public MyHashSet2() {
        hashSet = new boolean[hash1][];
    }

    public void add(int key) {
        if(!contains(key)){
            if(hashSet[getHash1(key)]==null){
                if(getHash1(key)==0) {
                    hashSet[getHash1(key)] = new boolean[hash2 + 1];
                }
                else{
                    hashSet[getHash1(key)] = new boolean[hash2];
                }
            }
            hashSet[getHash1(key)][getHash2(key)]=true;
        }
    }

    public void remove(int key) {
        if(contains(key)){
            hashSet[getHash1(key)][getHash2(key)]=false;
        }
    }

    public boolean contains(int key) {
        if(hashSet[getHash1(key)]==null){
            return false;
        }
        else{
            return hashSet[getHash1(key)][getHash2(key)];
//            if(hashSet[getHash1(key)][getHash2(key)]==false){
//                return false;
//            }
//            else{
//                return true;
//            }
        }
    }
}



class MyHashSet1 {
    Node[] hashSet;

    class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public MyHashSet1() {
        hashSet = new Node[10];
    }

    public void add(int key) {

        int hashValue = key%hashSet.length;
        if(hashSet[hashValue]!= null){

            Node temp = hashSet[hashValue];
            if(temp.data != key){
                while( temp.data !=key && temp.next!=null){
                    temp = temp.next;
                }
                if(temp.data == key){

                }
                else{
                    Node node =  new Node(key);
                    temp.next = node;
                }
            }
        }
        else{
            Node node = new Node(key);
            hashSet[hashValue] = node;
        }
    }

    public void remove(int key) {
        if(hashSet[key%hashSet.length] != null){
            Node temp = hashSet[key%hashSet.length];
            if(temp.data == key){
                hashSet[key%hashSet.length] = temp.next;
            }
            else{
                if(temp.next != null) {
                    Node temp2 = temp.next;

                    while (temp2.data != key & temp2.next != null) {
                        temp2 = temp2.next;
                        temp = temp.next;
                    }

                    if(temp2.next == null){
                        temp.next = null;
                    }else{
                        temp.next = temp2.next;
                    }
                }
            }
        }
    }

    public boolean contains(int key) {

        if(hashSet[key%hashSet.length] == null){
            return false;
        }
        else{
            Node temp = hashSet[key%hashSet.length];
            if(temp.data == key){
                return true;
            }
            else{
                if(temp.next == null){
                    return false;
                }
                else{
                    while (temp.data != key && temp.next != null){
                        temp =  temp.next;
                    }
                    if(temp.data == key){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
    }
}
