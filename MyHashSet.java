
public class MyHashSet {

    int h_index;
    int v_index;
    boolean[][] hashset;

    //Calculate hash1;
    private int getH_index(int key)
    {
        return key%h_index;
    }
    private int getV_index(int key)
    {
        return key/v_index;
    }

    public void add(int key)
    {
        int h = getH_index(key);
        int v = getV_index(key);
        if(hashset[h] == null)
        {
            hashset[h] = new boolean[v_index];
        }
        hashset[h][v] = true;
    }

    public void remove(int key)
    {
        int h = getH_index(key);
        int v = getV_index(key);

        if(hashset[h] == null)
            return;
        hashset[h][v] = false;
    }

    public boolean contains(int key)
    {
        int h = getH_index(key);
        int v = getV_index(key);

        if(hashset[h] == null)
            return  false;

        return hashset[h][v];
    }
}

/*
* Time complexity - removing, adding key = O(1)
* Space Complexity - O(N)
* Approach: Intializing first array with 1000 buckets ; and to handle the edge case of value being 10^6; Vertical arrays would be of size 1001
* Checking if the horizontal array has value null, means it was never touched and so we are intializing its bucket with 1001 items.
* now , for adding we just check it the value of horizontal is not null, if so, I will intialize it first and assign 1001 bucket items array to that index.
* otherwise, it means that it was already not null, so, we will just go with the index and update the values to true!
*
* same way for removing we just check the null condition and return the index value (irrespective of it is false ot true!)
* */
