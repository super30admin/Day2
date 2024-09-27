# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

Declared 2 stacks(In, Out).
when pushes, pushes to stack(In)
When pop or peek is called  all data in stack(In) is pushed to stack(Out) untill stack(In) is empty.

then pop or peek is done on top of stack(Out).

if both stacks(In, Out) are empty empty() returns true else false.



## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

declared 2D array of storage.
divided each dimesion based on square root.

in constructor declared only single dimesional length.
when an index of that array is called then instialized second dimensional length.

quotient is for major index.
reminder for sub index.





