import java.util.Arrays;

public class MyHashMap {
    int[] hashMap;

    public MyHashMap() {
        hashMap = new int[16];
        Arrays.fill(hashMap, -1);
    }

    // Average TC to put is O(1)
    public void put(int key, int value) {
        if (key >= hashMap.length) {
            int[] extendedArray = new int[key + 1];
            Arrays.fill(extendedArray, hashMap.length, extendedArray.length - 1, -1);
            System.arraycopy(hashMap, 0, extendedArray, 0, hashMap.length);
            hashMap = extendedArray;
        }
        hashMap[key] = value;
    }

    // TC is O(1)
    public int get(int key) {
        if (key < hashMap.length) {
            return hashMap[key];
        }
        return -1;
    }

    // TC is O(1)
    public void remove(int key) {
        if (key < hashMap.length) {
            hashMap[key] = -1;
        }
    }

    public static void main(String arr[]) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 5);
        int param_2 = obj.get(1);
        obj.remove(1);
    }
}