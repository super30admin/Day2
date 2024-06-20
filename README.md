# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

push operation O(1);- push into first stack only
pop also O(1);- before pop put first stack values into second use them for pop until it is empty. if another pop come check the first stack and pop it (if it has elements) to push into the second stack. then pop
peek and is empty is also O(1). peek form second stack. isempty check both stacks are empty.

## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
put, get, remove all are O(1)
create an array of nodes of 10000. the each node has a linked list attached as elements come in.



