/*
 *              Design a hashmap

 https://leetcode.com/problems/design-hashmap/

 * Time Complexity : O(k) where k is the number of elements.
 * Space Complexity : O(n+m) where n is the unique key and m is the bucket size
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * Your code here along with comments explaining your approach :
 *              - Using linear chaining.
*/
#include<iostream>
#include<vector>
#include<list>
#include<utility>

using namespace std;

/*
 Brute force approach :

    class hashmap {
        vector<int> map;
        int size = 1e6 + 1;

        hashmap() {
            map.resize(size);
        }

        void push(int key, int value) {
            map[key] = value;
        }

        int get(int key) {
            return map[key];
        }

        void remove(int key) {
            map[key] = -1;
        }
    };
*/

class hashmap {
    public:
        vector<list<pair<int, int> > > map;
        int size = 1e6; // This can be adjusted since we are handling the collisions.

        hashmap() {
            map.resize(size);
        }

    public:
        int hash(int key) {
            return key%size;
        }

        list<pair<int, int> > :: iterator search(int key) {
            int index = hash(key);

            list<pair<int, int> > :: iterator it = map[index].begin();

            while(it != map[index].end()) {
                if (it->first == key) {
                    return it;
                }
                it++;
            }
            return it;
        }

        void push(int key, int value) {
            int index = hash(key);
            list<pair<int, int> > :: iterator it = search(key);
        
            if (it != map[index].end()) {
                it->second = value;
            } else {
                map[index].push_back(make_pair(key, value));
            }
        }

        void remove(int key) {
            int index = hash(key);
            list<pair<int, int> > :: iterator it = search(key);

            if (it != map[index].end()) {
                map[index].erase(it);
            }
        }

        int get(int key) {
            int index = hash(key);
            list<pair<int, int> > :: iterator it = search(key);

            if (it == map[index].end()) {
                return -1;
            }

            return it->second;
        }
};

int main(){
    hashmap* map = new hashmap();

    map->push(1, 4);
    map->push(2, 8);
    map->push(3, 12);
    map->push(4, 16);
    map->push(5, 20);

    // Get values for keys
    cout << "Key 1 has value: " << map->get(1) << endl; 
    cout << "Key 2 has value: " << map->get(2) << endl; 
    cout << "Key 3 has value: " << map->get(3) << endl; 
    cout << "Key 6 has value: " << map->get(6) << endl; // Should output -1 (not found)

    return 0;
}
/*
 * Output of the program :
   Key 1 has value: 4
   Key 2 has value: 8
   Key 3 has value: 12
   Key 6 has value: -1
 */