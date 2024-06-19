class MyHashMap {
    int [][] hashMap;
    int priArrSize;
    int secArrSize;

    public MyHashMap() {
        int priArrSize = 1000;
        hashMap = new int[priArrSize][];
    }
    
    public void put(int key, int value) {
        int priArrIndex = key%1000;
        int secArrIndex = key/1000;
        if(priArrIndex == 0) {
            if(hashMap[priArrIndex]==null) {
                hashMap[priArrIndex] = new int[1001];
                Arrays.fill(hashMap[priArrIndex],-1);
            }
            hashMap[priArrIndex][secArrIndex] = value;
        }else{
            if(hashMap[priArrIndex]==null) {
                hashMap[priArrIndex] = new int[1000];
                Arrays.fill(hashMap[priArrIndex],-1);
            }
            hashMap[priArrIndex][secArrIndex] = value;
        }
    }
    
    public int get(int key) {
        int priArrIndex = key%1000;
        int secArrIndex = key/1000;
        if(hashMap[priArrIndex] == null)
            return -1;
        return hashMap[priArrIndex][secArrIndex];
    }
    
    public void remove(int key) {
        int priArrIndex = key%1000;
        int secArrIndex = key/1000;
        if(hashMap[priArrIndex] == null) return;
        hashMap[priArrIndex][secArrIndex] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */