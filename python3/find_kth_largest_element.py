import random


def find_k_th_largest(nums, k):
    """time complexity restriction: O(n)"""
    if k < 0 or k > len(nums) or nums == None:
        return False

    left = 0
    right = len(nums) - 1
    index = partition_1(nums, left, right)
    while index != len(nums) - k:
        if len(nums) - k > index:
            index = partition_1(nums, index + 1, right)
        elif len(nums) - k < index:
            index = partition_1(nums, left, index - 1)
    return nums[index]


def partition_1(ls, start, end):
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


def partition_2(ls, start, end):
    """左右指针, use leftmost element as pivot"""
    i = start
    j = end
    pivot = ls[start]
    while i != j:
        while ls[j] >= pivot and i < j:  # move j firstly
            j -= 1
        while ls[i] <= pivot and i < j:
            i += 1
        if i < j:
            ls[i], ls[j] = ls[j], ls[i]

    ls[i], ls[start] = ls[start], ls[i]
    return j


print(find_k_th_largest([3, 2, 1, 5, 6, 4], 1))
print(find_k_th_largest([3, 2, 1, 5, 6, 4], 6))
