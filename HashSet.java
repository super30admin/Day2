class MyHashSet {
    private final int MAX = 100000;
    private final int ARR = 100;
    private List<List<Integer>> p;
    /** Initialize your data structure here. */
    public MyHashSet() {
        p = new ArrayList<>(ARR);
        for(int i=0;i<ARR;i++){
            p.add(null);
        }
    }
    
    public void add(int key) {
        int index = key % ARR;
        List<Integer> c = p.get(index);
        if(c==null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            p.set(index,list);
        }else{
            if(!c.contains(key)){
                c.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key%ARR;
        List<Integer> c = p.get(index);
        if(c!=null){
            c.remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%ARR;
        List<Integer> c = p.get(index);
        return (c!=null && c.contains(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
