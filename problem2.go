// HashMap implementation

const BucketCount=1000
const BucketItemCount=1000

type Bucket struct {
    BucketItems []*BucketItem
}

type BucketItem struct {
    Item int
}

type MyHashMap struct {
    storage []*Bucket
    bucketCount int
    bucketItemCount int
}


func Constructor() MyHashMap {
    return MyHashMap {
        storage: make([]*Bucket, BucketCount),
        bucketCount: BucketCount,
        bucketItemCount: BucketItemCount,
    }
}

func (this *MyHashMap) hash1(key int) int{
    return key % this.bucketCount
}

func (this *MyHashMap) hash2(key int) int{
    return key / this.bucketCount
}

func (this *MyHashMap) Put(key int, value int)  {
    id1 := this.hash1(key)
    id2 := this.hash2(key)
    if this.storage[id1] == nil {
        this.storage[id1] = &Bucket{}
        if id1 == 0 {
            this.storage[id1].BucketItems = make([]*BucketItem, this.bucketItemCount + 1)
        } else {
            this.storage[id1].BucketItems = make([]*BucketItem, this.bucketItemCount)
        } 
    }
    if this.storage[id1].BucketItems[id2] == nil {
        this.storage[id1].BucketItems[id2] = &BucketItem{value}
        return
    }
    this.storage[id1].BucketItems[id2].Item = value
}


func (this *MyHashMap) Get(key int) int {
    id1 := this.hash1(key)
    id2 := this.hash2(key)
    if this.storage[id1] == nil {
        return -1
    }
    if this.storage[id1].BucketItems[id2] == nil {
        return -1
    }
    return this.storage[id1].BucketItems[id2].Item
}


func (this *MyHashMap) Remove(key int)  {
    id1 := this.hash1(key)
    id2 := this.hash2(key)
    if this.storage[id1] == nil {
        return
    }
    this.storage[id1].BucketItems[id2] = nil
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Put(key,value);
 * param_2 := obj.Get(key);
 * obj.Remove(key);
 */