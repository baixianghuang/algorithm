def max_product_after_cutting(length):
    ""a rope with length n is divided into m (integer) parts"""
    if length <= 0:
        return None
    elif 0 < length < 2:
        return 0
    elif length == 2:  # max_product_list[2] != 1
        return 1
    elif length == 3:  # max_product_list[3] != 2
        return 2

    max_product_list = [0, 1, 2, 3]

    for i in range(4, length+1):
        max_p = 0
        for j in range(1, i//2+1):
            if max_p < max_product_list[j] * max_product_list[i-j]:
                max_p = max_product_list[j] * max_product_list[i-j]
        max_product_list.append(max_p)
        # print(max_p)

    print(max_product_list[length])
    return max_product_list[length]


max_product_after_cutting(9)
