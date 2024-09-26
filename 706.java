

class MyHashMap {
    int ans[];
    int size=1000001;
    public MyHashMap() {
       ans=new int[size]; 
    }
    
    public void put(int key, int value) {
        ans[key]=value+1;
    }
    
    public int get(int key) {
      return ans[key]-1;
        
    }
    
    public void remove(int key) {
        ans[key]=0;
    }
}