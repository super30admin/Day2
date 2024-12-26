// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Used actually an arraylist that will store the key and value

import java.util.ArrayList;

class MyHashMap {
    ArrayList<int[]> list;
    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int check = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)[0] == key){
                list.get(i)[1] = value;
                check = 1;
                break;
            }
        }
        if(check == 0){
            int[] item = new int[2];
            item[0] = key;
            item[1] = value;
            list.add(item);
        }
    }
    
    public int get(int key) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)[0] == key){
                return list.get(i)[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)[0] == key){
                list.remove(i);
            }
        }
    }
}
