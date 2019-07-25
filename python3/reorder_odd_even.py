def reorder_odd_even(ls):
    start = 0
    end = len(ls) - 1
    
    while start < end:
        while start < end and ls[start] & 0x1 == 1:
            start += 1
        while start < end and not ls[end] & 0x1 == 1:
            end -= 1
        if start < end:
            ls[start], ls[end] = ls[end], ls[start]

    print(ls)


reorder_odd_even([2, 4, 6, 1, 3, 5])
