class MyHashSet {
private:
	int prime;
	vector<list<int>> table;
//completed the code in  C++ with linked list + array combo. The java approach couldn't work in here, I could use vector<vector<bool>>, but I'd need to initialize with size beforehand
    //this is still O(1) all approach
	int hash(int key) {
		return key % prime;
	}

	list<int>::iterator search(int key) {
		int h = hash(key);
		return find(table[h].begin(), table[h].end(), key);
	}

public:
	MyHashSet() {
        prime = 10007;
        table.resize(prime);
    }
	
	void add(int key) {
		int h = hash(key);
		if (!contains(key))
			table[h].push_back(key);
	}
	
	void remove(int key) {
		int h = hash(key);
		auto it = search(key);
		if (it != table[h].end())
			table[h].erase(it);
	}
	
	bool contains(int key) {
		int h = hash(key);
		return search(key) != table[h].end();
	}
};
