import random


def smallest_k_elements(ls, k):
    """time complexity restriction: O(n), the input list can be modified"""
    if ls == None or k <= 0 or k > len(ls):
        return None

    start = 0
    end = len(ls) - 1
    index = partition(ls, start, end)

    while index != k-1:
        if index > k - 1:
            index = partition(ls, start, index - 1)
        if index < k - 1:
            index = partition(ls, index + 1, end)

    print(ls[:k])
    return ls[:k]


def partition(ls, start, end):
    """randomly choose pivot"""
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


smallest_k_elements([7, 1, 5, 9, 3], 3)
