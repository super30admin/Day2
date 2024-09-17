/ Time Complexity :all operations T(n) = O(1) ==> add,remove,contains
// Space Complexity :S(n)=O(n)
// Did this code successfully run on Leetcode :yes

//double hashing 


class MyHashSet {
public:
    vector<vector<bool>>map;
    int getBucket(int key)
    {
        return key%1000;
    }
    int getBucketItem(int key)
    {
        return key/1000;
    }
    MyHashSet() 
    {
        this->map.resize(1000);
    }

    void add(int key) 
    {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(map[bucket].size()<bucketItem+1)
        {
            map[bucket].resize(bucketItem+1,false);
        }
        map[bucket][bucketItem]=true;
    }

    void remove(int key) 
    {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(map[bucket].size()<bucketItem+1)
        {
            return;
        }
        map[bucket][bucketItem]=false;
        return;
    }

    bool contains(int key) 
    {

        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(map[bucket].size()<bucketItem+1)
        {
            return false;
        }
        return map[bucket][bucketItem];

    }
};
