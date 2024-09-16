namespace CustomDataStructures
{
    public class MyHashSet
    {
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        private bool[][] arr;
        private int buckets;
        private int bucketItems;

        /** Initialize your data structure here. */
        public MyHashSet()
        {
            buckets = 1000;
            bucketItems = 1000;
            arr = new bool[buckets][];
        }

        //Hash function for caluclating index of the buckets
        public int Bucket(int key)
        {
            return key % buckets;
        }

        //Hash function for caluclating index of the bucket items (Nested index - index for the nested structure)
        public int BucketItem(int key)
        {
            return key / bucketItems;
        }

        //Time Complexity - O(1)
        //Space Complexity - O(n) in this method - Since we have to just allocated BucketItems here
        public void Add(int key)
        {
            var bucket = Bucket(key);
            var bucketItem = BucketItem(key);
            if (arr[bucket] == null)
            {
                if (bucket == 0)
                {
                    // If the key is 10^6, then our hash function returns 1000 for the 0th index,
                    // where as we can only store 0 to 999 bucketItems, for this reason I am checking if the first index is 0, 
                    // then allocate 1001 elements so that my index can go upto 1000 for the bucket 
                    arr[bucket] = new bool[bucketItems + 1];
                }
                else
                {
                    arr[bucket] = new bool[bucketItems];
                }
            }
            arr[bucket][bucketItem] = true;
        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        public void Remove(int key)
        {
            var bucket = Bucket(key);
            var bucketItem = BucketItem(key);
            if (arr[bucket] == null) return;
            arr[bucket][bucketItem] = false;
        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        /** Returns true if this set contains the specified element */
        public bool Contains(int key)
        {
            var bucket = Bucket(key);
            var bucketItem = BucketItem(key);
            if (arr[bucket] == null)
            {
                return false;
            }
            return arr[bucket][bucketItem];
        }
    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.Add(key);
     * obj.Remove(key);
     * bool param_3 = obj.Contains(key);
     */
}
