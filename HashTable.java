class HashTable{

    //I am using String array as a practice to see what happens when Strings are stored in HashMap/HashTable
    String[] hashArr;
    int size;
    int arrSize;

    public HashTable(int numOfSlots){
        //This i read in some documentation that it is always better to have prime number as slots.
        //The main reason can be due to the use of mod operator to calculate the index, prime number helps.

        //So I am going to check if the number of slots are prime. if not then i will check the next available
        //prime number and assign it to the the slot.
        if (isPrime(numOfSlots)) {
            hashArr = new String[numOfSlots];
            arrSize = numOfSlots;
        }
        else{
            int nextPrimeNumber = getNextPrimeNumber(numOfSlots);
            hashArr = new String[nextPrimeNumber];
            arrSize = nextPrimeNumber;
        }
    }

    private boolean isPrime(int numOfSlots){

        for (int i = 2; i*i <= numOfSlots; i++){
            if (numOfSlots % i == 0){
                return false;
            }
        }
        return true;
    }

    private int getNextPrimeNumber(int numOfSlots){
        int i = numOfSlots;
        while (true){
            if (isPrime(i)){
                return i;
            }
            i++;
        }
    }

    /*
    Now that we have proper size of the array, we need to have hashfunctions for double hashing.
    We will have two hash functions. First one will find a slot. If the element is already present
    then we will use one more hashfunction which will skip the clusters/clumps and try to insert the
    element in new position
     */

    private int hashFunction1(String word){
        int index = word.hashCode();
        index = index % arrSize;

        //sometimes Java can return negative hashcode, hence  we will try to avoid this
        if (index < 0){
            index += arrSize;
        }
        return index;
    }

    private int hashFunction2(String word){
        int index = hashFunction1(word);

        return 3 - index%3;
        //please note, there are multiple methods to determine the new index...this one is easiest
        //the value 3 can be anything here...but it has to be less than arraySize and also it should be prime.
    }

    //insert function
    private void insert(String word){
        int index = hashFunction1(word);
        int skipIndex = hashFunction2(word);

        while (hashArr[index]!=null){
            //add the steps to original index if it is not null
            index = index + skipIndex;
            //make sure after addition it is inside arraySize;
            index = index % arrSize;
        }

        //insert
        hashArr[index] = word;
        size++;
    }

    private String search(String word){

        int index = hashFunction1(word);
        int skipIndex = hashFunction2(word);

        while (hashArr[index]!=null){
            //check for the element in position
            if (hashArr[index].equals(word)){
                return hashArr[index];
            }

            //add the steps to original index if it is not null
            index = index + skipIndex;
            //make sure after addition it is inside arraySize;
            index = index % arrSize;
        }
        //if not found then anyway it will return null
        return hashArr[index];
    }
}