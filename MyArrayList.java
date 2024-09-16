
import java.util.Arrays;

public class MyArrayList {
    int[] arr;
    int count;
    static final int initialCapacity = 10;
    double loadFactor = 0.8;
    double shrinkFactor = 0.4;
    int bucketSize;
    public MyArrayList() {
        bucketSize = initialCapacity;
        arr = new int[bucketSize];
        count = 0;
    }
    public void add(int val) {
        if(getCurrentLoad() >= loadFactor) {
            bucketSize = bucketSize * 2;
            int[] newArr = new int[bucketSize];
            System.arraycopy(arr, 0, newArr, 0, count);
            arr = newArr;
        }
        arr[count] = val;
        count++;
    }

    public void remove(int inx) {
        if(inx >= count) return;
        for(int i=inx;i<count;i++) {
            arr[i] = arr[i+1];
        }
        arr[count] = 0;
        count--;
        if(getCurrentLoad() <= shrinkFactor) {
            bucketSize = (int)Math.floor(bucketSize / 2);
            int[] newArr = new int[bucketSize];
            System.arraycopy(arr, 0, newArr, 0, count);
            arr = newArr;
        }
        System.out.println(Arrays.toString(arr));
   }

   private double getCurrentLoad(){
      return  (double)count/bucketSize;
   }

    public int get(int inx) {
        if(inx > count)  return -1;
        return arr[inx];
    }

    public int size() {
        return this.count;
    }

    public static void main(String[] args) {
        MyArrayList arrList = new MyArrayList();
        for(int i=0;i<12;i++) {
            arrList.add(i+1);
        }
        for(int i=2;i<=12;i++) {
            arrList.remove(2);
        }
        System.out.println(arrList.size());
    }
}
