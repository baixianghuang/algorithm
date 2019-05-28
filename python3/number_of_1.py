INT_BITS = 32
MAX_INT = (1 << (INT_BITS - 1)) - 1  # Maximum Integer for INT_BITS


def number_of_1(n):
    """
    input a decimal number, return the number of 1s in its binary format
    Note: in python -1 >> n still is -1, therefore the input "-1" causes an infinite loop
    """
    cnt = 0

    # 1) method 1
    # while n != 0:
    #     # print(n)
    #     if n % 2 == 1:  # equals to if n & 1 == 1:
    #         cnt += 1
    #     n = n // 2  # equals to n = n >> 1

    # 2) method 2, shift 1 instead of n
    # bit = 1
    # while n and bit <= MAX_INT + 1:
    #     if bit & n:
    #         cnt += 1
    #         n -= bit
    #     bit = bit << 1

    # 2) method 3: the best
    while n != 0:
        if n < - MAX_INT - 1 or n > MAX_INT:
            break
        n = n & (n-1)
        cnt += 1

    return cnt


print(number_of_1(MAX_INT))
