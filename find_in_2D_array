def find_in_2D_array(a, n):
    if a == None:
        return False
 
    end_i = len(a[0]) - 1
    end_j = len(a) - 1
    # print(end_i, end_j)
 
    if a[end_i][end_j] < n:
        return False
 
    i = 0
    j = end_j
    while n < a[i][j] and j >= 0:
        j -= 1
 
    while n > a[i][j] and i <= end_i:
        i += 1
 
    if a[i][j] == n:
        print(i, j, a[i][j])
        return True
    else:
        return False
 
print(find_in_2D_array([[1,2,8,9], [2,4,9,12], [4,7,10,13], [6,8,11,15]], -1))
