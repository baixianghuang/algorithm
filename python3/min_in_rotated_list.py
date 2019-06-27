def min_in_rotated_list(ls):
    if ls == None:
        return False

    start = 0
    end = len(ls) - 1

    while ls[start] >= ls[end]:
        if end - start == 1:
            return ls[end]
        mid_index = (start + end) >> 1

        # have to perform linear search
        if ls[mid_index] == ls[start] and ls[mid_index] == ls[end]:
            return linear_min_search(ls)

        # print(mid_index, L[mid_index])
        if ls[mid_index] >= ls[start]:
            start = mid_index
        elif ls[mid_index] <= ls[end]:
            end = mid_index

    return ls[start]


def linear_min_search(L):
    ans = L[0]
    for e in L:
        if e < ans:
            ans = e
    return ans


print(linear_min_search([1, 1, 1, 0, 1]))
print(min_in_rotated_list([3, 4, 5, 1, 2]))
print(min_in_rotated_list([1, 2, 3, 4, 5]))  # special case 1
print(min_in_rotated_list([1, 1, 1, 0, 1]))  # special case 2
