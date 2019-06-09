def all_subsets(ls):
    if ls == None:
        return None
    if len(ls) == 0:
        return [[]]
    subsets = []
    f = ls[0]  # first element in ls
    rest = ls[1:]  # rest element in ls
    for e in all_subsets(rest):
        subsets.append(e)
        subsets.append([f] + e[:])
    return subsets

print(all_subsets([]))
print(all_subsets([1,2,3]))
