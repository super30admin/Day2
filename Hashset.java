class MyHashSet {
    boolean arr[][];
    private static int h1=1000;
    private static int h2=1000;

    public MyHashSet() {
        this.arr=new boolean[h1][];
    }
    
    public void add(int key) {
        if(!contains(key)){
            int key1=hash1(key);
            if(key1==0){
               arr[key1]=new boolean[h1+1];
            }
            else{
                arr[key1]=new boolean[h1];
            }
            
             int key2=hash2(key);
            arr[key1][key2]=true;
        }
    }
    public int hash1(int key){
        return key%1000;
    }
    public int hash2(int key){
        return key/1000;
    }
    
    public void remove(int key) {
        if(contains(key)){
            int key1=hash1(key);
            int key2=hash2(key);
            arr[key1][key2]=false;
        
        }
        
    }
    
    public boolean contains(int key) {
        int key1=hash1(key);
       
        if(arr[key1]==null){
            return false;}
        
            int key2=hash2(key);
            System.out.println(arr[key1][key2]);
            return arr[key1][key2];
        
        
    }
}
