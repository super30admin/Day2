// Time Complexity : 53ms [faster than 46.66% submissions]
// Space Complexity : 56MB [less than 85.75% submissions]
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
// I made an array which can hold 10^6+1 elements
// then I made a for loop to designate each element as -1
// everything else if quite straightforward, I considered key(as index number) and
// value (element for the respective index.)


class MyHashMap {

    
    int[] arr = new int[1000001];
    
    
    public MyHashMap() {
        for (int i = 0; i < 1000001; i++){
            arr[i] = -1;
        }    
    }
    
    public void put(int key, int value) {
        arr[key] = value;    
    }
    
    public int get(int key) {
        
        return arr[key];
        
    }
    
    public void remove(int key) {
        arr[key] = -1;
    }
}

// approach 2
// class MyHashMap {

    
//     int[][] arr = new int[1001][1001];
    
    
//     public MyHashMap() {
        
//         for (int i = 0; i < 1001;i++){
//             for (int j = 0; j < 1001;j++){
//                 arr[i][j] = -1;
//             }
           
//         }    
//     }
    
//     public void put(int key, int value) {
//         arr[key/1001][key%1001]=value;    
//     }
    
//     public int get(int key) {
        
//         return arr[key/1001][key%1001];
        
//     }
    
//     public void remove(int key) {
//         arr[key/1001][key%1001] = -1;
//     }
// }