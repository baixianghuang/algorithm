def max_sum_sub_array(nums):
    """
    note that a sub-array has to be continuous(e.g. [1,-2,3])
    time complexity restriction: O(n)
    """
    if nums == None or len(nums) == 0:
        return False
            
    cur_sum = 0
    max_sum = -float('Inf')
    for i in range(len(nums)):
        if cur_sum <= 0:
            cur_sum = nums[i]
        else:
            cur_sum += nums[i]
            
        max_sum = max(cur_sum, max_sum)
    return max_sum


print(max_sum_sub_array([1,-2,3,10,-4,7,2,-5]))
print(max_sum_sub_array([-2, -8, -1, -5, -9]))
print(max_sum_sub_array([2, 8, 1, 5, 9]))  
print(max_sum_sub_array(None)) 
