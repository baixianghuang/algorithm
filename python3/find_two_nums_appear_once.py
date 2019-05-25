def find_two_nums_appear_once(ls):
    """solution 1 focus on a property of xor operation: a^b^a = b"""
    # ==========solution 1:
    def get_n_digit(num):
        """find the last '1'(right-to-left) in binary form of num"""
        cnt = 0
        while num & 1 != 1:
            num >>= 1
            cnt += 1
        # print(cnt)
        return cnt
 
    def n_digit_1_or_0(num, n):
        for i in range(n):
            num >>= 1
        if num & 1 == 1:
            return True
        else:
            return False
 
    def xor_list(ls):
        ans = 0  # 0^a = a
        for e in ls:
            ans ^= e
        return ans
 
    # store the xor result of two numbers that only appear once
    xor_of_2_nums = xor_list(ls)
    n = get_n_digit(xor_of_2_nums)
 
    # divide the ls into 2 parts according to whether the n-th (right-to-left) digit is 0 or 1
    # print(n_digit_1_or_0(15, 3))
    ls1, ls2 = [], []
    for e in ls:
        if n_digit_1_or_0(e, n):
            ls1.append(e)
        else:
            ls2.append(e)
    print(ls1, ls2)
 
    # find the final result from each list
    print(xor_list(ls1), xor_list(ls2))
    return xor_list(ls1), xor_list(ls2)
 
    # ==========solution 2: use a dictionary
    # count = {}
    # for e in ls:
    #     if e in count:
    #         count[e] += 1
    #     else:
    #         count[e] = 1
    # for e in ls:
    #     if count[e] == 1:
    #         print(e)
 
 
find_two_nums_appear_once([4, 2, 3, 6, 3, 2, 5, 5])  #
 
# ==========follow up==========
def find_num_appearing_once(ls):
    """only 1 num appears once, remaining nums in the list appear 3 times
    core idea: add up binary forms of nums, for those bits % 3 != 0, they are the num appears once """
 
    sum_bin = 0
    ans = []  # can also define a list with a length of 32 for 32 bit machine
    result = 0  # decimal
    for e in ls:
        # print(int(format(e, 'b')))
        sum_bin += int(format(e, 'b'))
    print(sum_bin)
 
    # record which bit cannot mod 3
    while sum_bin != 0:
        bit = sum_bin % 10
        if bit % 3 != 0:
            ans.append(1)
        else:
            ans.append(0)
        sum_bin //= 10
    print(ans)
 
    # convert ans into decimal
    pow = len(ans) - 1
    while len(ans) != 0:
        result += ans.pop() * 2**pow
        pow -= 1
    print(result)
 
 
find_num_appearing_once([1, 1, 1, 2, 13, 13, 13])
