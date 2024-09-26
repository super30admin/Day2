
from inspect import stack

stack_1 = []
stack_2 = []


def push_stack(val):
    stack_1.append(val)


def pop_stack():
    if len(stack_2) == 0:
        while len(stack_1) != 0:
            stack_2.append(stack_1.pop())
    return stack_2.pop()


def peek():
    if len(stack_2) == 0:
        while len(stack_1) != 0:
            stack_2.append(stack_1.pop())

    return stack_2[-1]


push_stack(1)
push_stack(2)
push_stack(3)
push_stack(4)
# pop_stack()
# # print(len(stack_2))
# pop_stack()
# # print(len(stack_2))
# pop_stack()
push_stack(5)
pop_stack()
push_stack(6)
print(peek())
