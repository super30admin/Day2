class MyHashMap {

    int buckets;
    int bucketsSize;
    Integer[][] arr;

    public MyHashMap() {
        buckets = 1000;
        bucketsSize = 1000;
        arr  = new Integer[buckets][];
    }



    public void put(int key, int value) {
        int h1 = getHash1(key);
        int h2 = getHash2(key);

        if(arr[h1] == null)
        {
            if(h1 == 0)
                arr[h1] = new Integer[bucketsSize+1];
            else
                arr[h1] = new Integer[bucketsSize];

            //for(int i=0; i < arr[h1].length; i++){
            //  arr[h1][i] = -1;
            // }
        }
        //System.out.println(arr[h1][h2]);
        arr[h1][h2] = value;

    }

    public int get(int key) {
        int h1 = getHash1(key);
        int h2 = getHash2(key);

        if(arr[h1] == null)
            return -1;

        if(arr[h1][h2] == null)
            return -1;

        return arr[h1][h2];
    }

    public void remove(int key) {
        int h1 = getHash1(key);
        int h2 = getHash2(key);
        if(arr[h1] == null)
            return;

        if(arr[h1][h2] == null)
            return;

        arr[h1][h2] = -1;

    }

    public int getHash1(int key){
        return key%1000;
    }
    public int getHash2(int key){
        return key/1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */