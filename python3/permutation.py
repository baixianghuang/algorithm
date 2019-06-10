def permutation(ls):
    """print out the permutation of ls"""
    if ls == None:
        return None
    permutation_core(ls, 0)


def permutation_core(ls, left):
    if left == len(ls) - 1:
        print(ls)
    else:
        for i in range(left, len(ls)):
            ls[left], ls[i] = ls[i], ls[left]
            permutation_core(ls, left + 1)    
            ls[left], ls[i] = ls[i], ls[left]
            
 
permutation([1, 2, 3])
permutation(['a', 'b', 'c'])
