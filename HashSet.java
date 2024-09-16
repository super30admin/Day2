public class HashSet{
    private HashNode set[];
    private int numberOfBuckets;
    private int size;

    HashSet(){
        numberOfBuckets = 16;
        set = new HashNode[numberOfBuckets];
        size = 0;
    }

    private int getIndex(Integer x){
        //System.out.println("index" + " " +x.hashCode() % numberOfBuckets);
        return x.hashCode() % numberOfBuckets;
    }

    public void add(Integer x){
        int bucketIndex = getIndex(x);
        HashNode head = set[bucketIndex];
        HashNode newNode = new HashNode(x);
        if(head == null){
            set[bucketIndex] = newNode;
            size++;
            return;
        }
        while(head != null){
            //System.out.println("head.data " + head.data );
            if(head.data.equals(x)) return;
            if(head.next == null) {
                head.next = newNode;
                size++;
                break;
            }
        }

        if(1.0*size/numberOfBuckets >= 0.7){
            HashNode temp[] = set;
            numberOfBuckets = numberOfBuckets*2;
            set = new HashNode[numberOfBuckets];
            size =0;
            for(HashNode node : temp){
                add(node.data);
            }
        }
    }

    public boolean contains(Integer x){
        int bucketIndex = getIndex(x);
        HashNode head = set[bucketIndex];
        if(head == null) return false;
        while(head != null){
            if(head.data.equals(x)) return true;
            head = head.next;
        }
        return false;
    }

    public void remove(Integer x){
        int bucketIndex = getIndex(x);
        HashNode head = set[bucketIndex];
        if(head == null) return;
        HashNode prev = null;
        while(head != null){
            if(head.data.equals(x)) break;
            prev = head;
            head = head.next;
        }
        if(prev != null){
            prev.next = head.next;
        }else{
            set[bucketIndex] = head.next;
        }
        size--;
    }

    public int size(){
        return size;
    }
    public static void main(String [] args){
        HashSet set = new HashSet();
        set.add(10);
        set.add(2);
        set.add(4);
        set.add(26);

        System.out.println(set.size());
        System.out.println(set.contains(2));
        System.out.println(set.contains(14));
        set.remove(4);
        System.out.println(set.size());
        System.out.println(set.contains(4));
        
    }
   
}
class HashNode{
    Integer data;
    HashNode next;

    HashNode(Integer x){
        this.data = x;
        this.next = null;
    }
}