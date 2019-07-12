def has_path(matrix, rows, cols, string):
    """
    back-tracking
    find the string in the given matrix (1-D matrix version), input string cannot be a single char,
    otherwise return True due to 'if path_length == len(string) - 1: return True'
    """
    if cols < 1 or rows < 1:
        return False

    visited = []
    for e in matrix:
        visited.append(False)

    path_length = 0
    for row in range(rows):
        for col in range(cols):
            if has_path_core(matrix, rows, cols, row, col, string, path_length, visited):
                return True

    return False


def has_path_core(matrix, rows, cols, row, col, string, path_length, visited):
    if path_length == len(string) - 1:
        return True

    has_path = False
    if 0 <= row < rows and 0 <= col < cols and matrix[row * cols + col] == string[path_length] and not visited[
            row * cols + col]:
        path_length += 1
        visited[row * cols + col] = True
        has_path = has_path_core(matrix, rows, cols, row, col + 1, string, path_length, visited) or \
                   has_path_core(matrix, rows, cols, row, col - 1, string, path_length, visited) or \
                   has_path_core(matrix, rows, cols, row - 1, col, string, path_length, visited) or \
                   has_path_core(matrix, rows, cols, row + 1, col, string, path_length, visited)

    if not has_path:
        path_length -= 1
        visited[row * cols + col] = False

    return has_path


print(has_path(['a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'], 3, 4, 'deh'))
