// Time complexity O(1)
// Space complexity O(mxn)



class MyHashMap {

    fileprivate static let kHorizontalBucket = 1000

    fileprivate var horizontal: [Node]

    fileprivate func hashFunction(_ key: Int) -> Int {
        return key % MyHashMap.kHorizontalBucket
    }

    init() {
        self.horizontal = Array(repeating: Node(), count: MyHashMap.kHorizontalBucket)
    }

    func put(_ key: Int, _ value: Int) {
        let previous = getPrevious(key)
        
        if previous.link?.key == key {
            previous.link?.data = value
        } else {
            let node = Node(key, value, nil)
            node.link = previous.link
            previous.link = node
        }
    }

    func get(_ key: Int) -> Int {
        let prev = getPrevious(key)
        
        if prev.link == nil {
            return -1
        }
        
        return prev.link!.data
    }
    
    // Return previous node if node is present.
    // else return null
    fileprivate func getPrevious(_ key: Int) -> Node {
        let hashValue = hashFunction(key)
        let node = horizontal[hashValue]
        
        var previous = node
        var current = node.link
        
        while current != nil && current?.key != key {
            previous = current!
            current = current?.link
        }
        
        return previous
    }

    func remove(_ key: Int) {
        let previous = getPrevious(key)
        if previous.link?.key == key {
            previous.link = previous.link?.link
        }
    }
    
    func printList(_ value: Int) {
        let hashValue = self.hashFunction(value)
        var mynode: Node? = obj.horizontal[hashValue]
        while mynode != nil {
            print("Key is \(mynode!.key) and data is \(mynode!.data)")
            mynode = mynode!.link
        }
    }
}

class Node {
    var key: Int
    var data: Int
    var link: Node?
    
    // To create dummy node
    init() {
        self.key = Int.max
        self.data = Int.max
        self.link = nil
    }
    
    init(_ key: Int, _ data: Int, _ link: Node?) {
        self.key  = key
        self.data = data
        self.link = link
    }
    
    func isDummyNode() -> Bool {
        return self.key == Int.max
    }
}


//["MyHashMap","put","put","get","get","put","get","remove","get"]
//[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]

// let obj = MyHashMap()
// obj.put(1, 1)
// obj.printList(1)
// obj.put(2, 2)
// obj.printList(2)
// obj.get(1)
// obj.get(3)
// obj.put(2, 1)
// obj.printList(2)
// obj.get(3)
// obj.remove(2)
// obj.get(2)




