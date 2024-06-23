# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
Design Queue using Stack
First we will always push in in stack. 
For pop operation first we will check if out stack is empty if it is empty then we will first we will push all the elements from in stack to out stack. 
Then we will pop element from out stack. Same with empty function. We will peek from out stack and if it is empty we will move elements from in stack to out.


## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
First will initiate the storage array with null nodes (-1, -1) if the list is not initiated at that place in storage. 
Then we will find the place to insert the node in put method. If it is null for now then add the node otherwise just replace the value.
In find function we will check if the current node is not null and key is not there which we needs to find then we will traverse through the tree. 
Once we find the element we will exit the loop and return otherwise it will return null.
Same with remove. First will call find method and if we find that element we will delete the link of 2 nodes.



