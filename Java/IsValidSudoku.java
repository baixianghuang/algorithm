class IsValidSudoku {
  public boolean isValidSudoku(char[][] board) {
        if (board == null) { return false; }
        for(int i = 0; i < 9; i++) {
            if(!isSubSudokuValid(board, i, i, 0, 8)
                    || !isSubSudokuValid(board, 0, 8, i, i)
                    || !isSubSudokuValid(board, i / 3 * 3, i / 3 * 3 + 2, i % 3 * 3, i % 3 * 3 + 2)) return false;
        }
        return true;
    }

    public boolean isSubSudokuValid(char[][] board, int x1, int x2, int y1, int y2) {
        Set<Character> set = new HashSet<>();
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                    if(board[i][j] != '.' && !set.add(board[i][j])) { return false; }
//                if (board[i][j] == '.') { continue; }
//                if (set.contains(board[i][j])) { return false; }
//                set.add(board[i][j]);
            }
        }
        return true;
    }
}
