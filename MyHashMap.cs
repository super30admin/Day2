public class MyHashMap
{

    int[][] hashMap;
    int bucket, bucketItem;
    public MyHashMap()
    {
        this.bucket = 1000;
        this.bucketItem = 1000;
        hashMap = new int[this.bucket][];
    }

    public int GetBucket(int key)
    {
        return key % this.bucket;
    }

    public int GetBucketItem(int key)
    {
        return key / this.bucketItem;
    }

    public void Put(int key, int value)
    {
        var bucket = GetBucket(key);
        var bucketItem = GetBucketItem(key);
        if (hashMap[bucket] == null)
        {
            var bucketItemCount = bucket == 0 ? this.bucketItem + 1 : this.bucketItem;
            hashMap[bucket] = new int[bucketItemCount];
            for (var i = 0; i < bucketItemCount; i++)
            {
                hashMap[bucket][i] = -1;
            }
        }
        hashMap[bucket][bucketItem] = value;
    }

    public int Get(int key)
    {
        var bucket = GetBucket(key);
        var bucketItem = GetBucketItem(key);
        if (hashMap[bucket] == null)
        {
            return -1;
        }
        return hashMap[bucket][bucketItem];

    }

    public void Remove(int key)
    {
        var bucket = GetBucket(key);
        var bucketItem = GetBucketItem(key);
        if (hashMap[bucket] == null)
        {
            return;
        }
        hashMap[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */