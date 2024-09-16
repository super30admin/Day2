//Time complexity O(1) as it is array and direct access to memory
//Space Complexity = O(n) as we have to allocate the memory for 10^6
public class MyHashSet
    {

        public bool[,] storage;
        public int buckets;
        public int bucketItems;
        /** Initialize your data structure here. */
        public MyHashSet()
        {
            buckets = 1000;
            bucketItems = 1001;
            storage = new bool[buckets, bucketItems];
        }
        private int GetBucket(int key)
        {
            return key % buckets;
        }
        private int GetBucketItems(int key)
        {
            return key / bucketItems;
        }
        public void Add(int key)
        {
            int bucket = GetBucket(key);
            int bucketItem = GetBucketItems(key);
            if (storage[bucket, bucketItem] == false)
            {
               storage[bucket, bucketItem] = true;
            }
        }

        public void Remove(int key)
        {
            int bucket = GetBucket(key);
            int bucketItem = GetBucketItems(key);
            if (storage[bucket, bucketItem] == false) return;
            storage[bucket, bucketItem] = false;
        }

        /** Returns true if this set contains the specified element */
        public bool Contains(int key)
        {
            int bucket = GetBucket(key);
            int bucketItem = GetBucketItems(key);
            if (storage[bucket, bucketItem] == false) return false;
            return storage[bucket, bucketItem];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */