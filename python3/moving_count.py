def moving_count(threshold, cols, rows):
    if cols < 1 or rows < 1:
        return

    visited = []
    for i in range(cols*rows - 1):
        visited.append(False)
    result = moving_count_core(0, 0, cols, rows, threshold, visited)
    return result


def moving_count_core(row, col, rows, cols, threshold, visited):
    count = 0
    if 0 <= row < rows and 0 <= col < cols and visited[row*cols + col] == False and get_digits_sum(row, col) <= threshold:
        visited[row*cols + col] = True
        count = 1 + moving_count_core(row-1, col, rows, cols, threshold, visited) +\
                    moving_count_core(row+1, col, rows, cols, threshold, visited) +\
                    moving_count_core(row, col-1, rows, cols, threshold, visited) +\
                    moving_count_core(row, col+1, rows, cols, threshold, visited)
    return count


def get_digits_sum(x, y):
    sum = 0
    while x != 0:
        sum += x % 10
        x //= 10
    while y != 0:
        sum += y % 10
        y //= 10
    return sum


print(moving_count(5, 10, 10))
