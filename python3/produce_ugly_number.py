def produce_ugly_number_solution_1(n):
    """
    produce the n-th ugly number by generating n ugly number
    the ugly number next to K is some number prior to K times 2 or 3 or 5
    """
    ls = [1]  # store ugly number
    k = 0

    t2, t3, t5 = 0, 0, 0
    for i in range(n - 1):
        while 2 * ls[t2] < ls[i]:
            t2 += 1
        m2 = 2 * ls[t2]
        while 3 * ls[t3] < ls[i]:
            t3 += 1
        m3 = 3 * ls[t3]
        while 5 * ls[t5] < ls[i]:
            t5 += 1
        m5 = 5 * ls[t5]
        ls.append(min(m2, m3, m5))
        if ls[i + 1] == m2:
             t2 += 1
        if ls[i + 1] == m3:
             t3 += 1
        if ls[i + 1] == m5:
             t5 += 1
    return ls[n-1]


def produce_ugly_number_solution_2(n):
    """
    less efficient than solution_1, "for i in range(len(ls))" is more time-consuming
    """
    ls = [1]  # store ugly number
    k = 0
    while k < n:
        # find the first number * 2 or 3 or s larger than ls[k]
        for i in range(len(ls)):
            if ls[i] * 2 > ls[k]:
                m2 = ls[i] * 2
                break
        for i in range(len(ls)):
            if ls[i] * 3 > ls[k]:
                m3 = ls[i] * 3
                break
        for i in range(len(ls)):
            if ls[i] * 5 > ls[k]:
                m5 = ls[i] * 5
                break
        ls.append(min(m2, m3, m5))
        k += 1
    return ls[n-1]


def is_ugly(num):
    if num % 7 == 0:
        return False
    while num % 2 == 0:
        num /= 2
    while num % 3 == 0:
        num /= 3
    while num % 5 == 0:
        num /= 5
    if num == 1:
        return True
    else:
        return False


print(is_ugly(produce_ugly_number_solution_1(1500)))
print(is_ugly(produce_ugly_number_solution_2(1500)))
