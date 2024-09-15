import java.util.ArrayList;

class Bucket {
    ArrayList<Integer> keys; 

    public Bucket() {
        keys = new ArrayList<Integer>();
    }
}

public class HashSet {

    ArrayList<Bucket> buckets;
    final int num_buckets = 4099;

    public HashSet() {
        buckets = new ArrayList<Bucket>();
        for(int i=0; i<num_buckets; i++) {
            buckets.add(new Bucket());
        }
    }

    public void add(int key) {
        int bucket_index = key % num_buckets;
        ArrayList<Integer> keys = buckets.get(bucket_index).keys;
        boolean found = false;
        for(int i=0; i< keys.size(); i++) {
            int currKey = keys.get(i);
            if(currKey == key) {
                found = true;
            }
        }
        if (!found) {
            buckets.get(bucket_index).keys.add(key);
        }
    }
    
    public void remove(int key) {

        int bucket_index = key % num_buckets;
        ArrayList<Integer> keys = buckets.get(bucket_index).keys;
        for(int i=0; i< keys.size(); i++) {
            int currKey = keys.get(i);
            if(currKey == key) {
                keys.remove(i);
            }
        }
        
    }
    
    
    public boolean contains(int key) {

        int bucket_index = key % num_buckets;
        ArrayList<Integer> keys = buckets.get(bucket_index).keys;
        boolean found = false;
        for(int i=0; i< keys.size(); i++) {
            int currKey = keys.get(i);
            if(currKey == key) {
                found = true;
            }
        }

        return found;
        
    }
    
}