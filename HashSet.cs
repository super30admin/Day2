using System;
using System.Collections.Generic;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }

    public class MyHashSet
    {
        private int Range = 500;

        private List<int>[] hashSet = null;
        public MyHashSet()
        {

            hashSet = new List<int>[Range];
        }

        public void Add(int key)
        {
            if (Contains(key))
                return;

            int slot = key % Range;

            if (hashSet[slot] == null)
            {
                hashSet[slot] = new List<int>();
            }

            hashSet[slot].Add(key);
        }

        public void Remove(int key)
        {
            if (!Contains(key))
                return;

            int slot = key % Range;

            if (hashSet[slot] == null)
                return;

            for (int i = 0; i < hashSet[slot].Count; i++)
            {
                if (hashSet[slot][i] == key)
                {
                    hashSet[slot].RemoveAt(i);
                    return;
                }
            }

        }

        public bool Contains(int key)
        {

            int slot = key % Range;

            if (hashSet[slot] == null)
                return false;

            for (int i = 0; i < hashSet[slot].Count; i++)
            {
                if (hashSet[slot][i] == key)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
