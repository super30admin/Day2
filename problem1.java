import java.util.*;

public class problem1 {
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
     
    List<pair>[] map;

    public MyHashMap() {
        this.map = new ArrayList[10000];
    }
    
    public void put(int key, int value) {
        int hash = key%this.map.length;
        
        if(this.map[hash]==null){
                this.map[hash] = new ArrayList<>();
            }
        
        for(int i=0;i<this.map[hash].size();i++){
            if(this.map[hash].get(i).key==key){  
                this.map[hash].get(i).value = value;
                return; }
        }
        this.map[hash].add(new pair(key,value));
    }
    
    public int get(int key) {
        int hash = key%this.map.length;
        
        if(this.map[hash]==null){
                return -1;
            }
        
        for(int i=0;i<this.map[hash].size();i++){
            if(this.map[hash].get(i).key==key){  return this.map[hash].get(i).value;}
        }
        return -1;

    }
    
    public void remove(int key) {
        int hash = key%this.map.length;
        
        if(this.map[hash]==null){
                return ;
            }
        
        for(int i=0;i<this.map[hash].size();i++){
            if(this.map[hash].get(i).key==key){ this.map[hash].remove(i); return; }
        }
    }
}

class pair{
    int key;
    int value;
    
     pair(int key,int value){
        this.key = key;
        this.value = value;
    }
}
