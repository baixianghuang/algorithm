import random


def more_than_half_number(ls):
    """
    time complexity restriction: O(n)
    not allowed to use extra space
    """
    if ls == None:
        return None

    cnt = 0
    start = 0
    end = len(ls) - 1
    mid = len(ls) >> 1
    index = partition(ls, start, end)

    while index != mid:
        if index < mid:
            index = partition(ls, index + 1, end)
        else:
            index = partition(ls, start, index - 1)

    for e in ls:
        if e == ls[mid]:
            cnt += 1

    if cnt*2 > len(ls):
        return ls[mid]
    else:
        return None
        

def partition(ls, start, end):
    """前后指针, randomly choose pivot"""
    border = start
    rand_i = random.randint(start, end)
    pivot = ls[rand_i]
    ls[start], ls[rand_i] = ls[rand_i], ls[start]

    for i in range(start+1, end+1):
        if ls[i] < pivot and border < len(ls):
            border += 1
            ls[border], ls[i] = ls[i], ls[border]

    ls[start], ls[border] = ls[border], ls[start]
    return border


print(more_than_half_number([7,3,5,1,5,5,5,5]))
