public class MatrixMultiplication {
    public static void main(String[] args) {
        // 2x4 행렬 A 초기화
        int[][] matrixA = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };

        // 4x3 행렬 B 초기화
        int[][] matrixB = {
            {9, 10, 11},
            {12, 13, 14},
            {15, 16, 17},
            {18, 19, 20}
        };

        // 결과 행렬 C 초기화 (2x3 크기)
        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);

        // 결과 행렬 출력
        printMatrix(resultMatrix);
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int numRowsA = matrixA.length;
        int numColsA = matrixA[0].length;
        int numColsB = matrixB[0].length;

        int[][] resultMatrix = new int[numRowsA][numColsB];

        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                int sum = 0;
                for (int k = 0; k < numColsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                resultMatrix[i][j] = sum;
            }
        }

        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
