def max_product_after_cutting(length):
    """a rope is divided into m (integer) parts"""
    if length <= 0:
        return None
    elif 0 < length < 2:
        return 0
    elif length == 2:
        return 1
    elif length == 3:
        return 2

    ls = [0, 1, 2, 3]  # store max product with different length
    for i in range(4, length+1):
        ls.append(max(ls[i-2]*2, ls[i-3]*3))
    return ls[length]


print(max_product_after_cutting(9))
