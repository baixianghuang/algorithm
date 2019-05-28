def print1_to_n_largest(n):
"""
Big number problem print 1 to the largest n digits
"""
    if n <= 0:
        return

    L = []
    for i in range(n):
        L.append(0)
    # print(L)

    new_list = L[:]
    while True:
        new_list = add_one_list(new_list, n)
        print_list_to_num(new_list)
        list_convet_int = convert_list_to_int(new_list)
        if list_convet_int == 10**n - 1:
            break


def add_one_list(L, n):
    """simulate integer arithmetic to list"""
    result = L[:]
    carry = 1

    for i in range(n-1, -1, -1):  # note that L[len(L)] is exceed the range
        sum = L[i] + carry
        if sum == 10:
            carry = 1
        else:
            carry = 0
        result[i] = sum % 10

    return result


def print_list_to_num(L):
    """print the number represented by the list without 0s prefix"""
    is_beginning_0 = True
    for c in L:
        if c != 0 and is_beginning_0:
            is_beginning_0 = False

        if not is_beginning_0:
            print(c, end='')
    print()


def convert_list_to_int(L):
    list_to_str = ''
    for i in range(len(L)):
        list_to_str += str(L[i])
    return int(list_to_str)


print_1_to_n_largest(6)
