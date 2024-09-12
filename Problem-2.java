// Time Complexity : Add -> O(1), Remove -> O(1), Contains -> O(1)
// Space Complexity : O(N) Where N is 1000000
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Using boolean grid array and handling row and column hashing index
class MyHashSet {

    int maxRows = 1000; // rows index range from 0 to 999 (based on hash fn getRow())
    int maxCols = 1000; // cols index range from 0 to 999 (based on hash fn getCol())

    // boolean grid to flag the key
    private boolean[][] grid;

    /** Initialize your data structure here. */
    public MyHashSet() {
        // to use memory efficiently we dont initialize the column arrays
        grid = new boolean[maxRows][];
    }

    private int getRow(int key) {
        return key % 1000;
    }

    private int getCol(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int row = getRow(key);
        int col = getCol(key);

        if (grid[row] == null) {
            if (row == 0) {
                // For case when key is 1000000 can throw Array out of bound
                // Handling it by incrementing column
                grid[row] = new boolean[maxCols + 1];
            } else {
                // create column array
                grid[row] = new boolean[maxCols];
            }
        }
        grid[row][col] = true;

    }

    public void remove(int key) {
        int row = getRow(key);
        int col = getCol(key);

        if (grid[row] != null) {
            grid[row][col] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int row = getRow(key);
        int col = getCol(key);

        return grid[row] != null && grid[row][col];
    }
}