class RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        // Rotate a matrix by 90 degrees (clockwise)
        // Firstly, transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Then, flip the matrix horizontally
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length >> 1; j++) {
                int temp = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
