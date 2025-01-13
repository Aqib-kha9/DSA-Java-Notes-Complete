import java.util.ArrayList;
import java.util.List;

public class TwoDarrays {

    public static boolean searchMatrix(int matrix[][], int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int endRow = matrix.length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top Boundry
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
                result.add(matrix[startRow][j]);

            }

            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // Bottom
            if (startRow <= endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    System.out.print(matrix[endRow][j] + " ");
                }
            }

            // Left
            if (startCol <= endCol) {
                for (int i = endRow - 1; i >= startRow + 1; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return result;
    }

    public static boolean keySearc2DMat(int matrix[][], int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                System.out.print("matrixwa found at index " + row + " , " + col);
                return true;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        System.out.println("matrixwa mein targetwa not found");
        return false;
    }

    public static int numOccured(int matrix[][], int num) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (num == matrix[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int sumOfSecRow(int matrix[][]) {
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[1][j];
        }

        return sum;
    }

    public static void main(String[] args) {
        // int[][] matrix = {
        // { 1, 4, 7, 11, 15 },
        // { 2, 5, 8, 12, 19 },
        // { 3, 6, 9, 16, 22 },
        // { 10, 13, 14, 17, 24 },
        // { 18, 21, 23, 26, 30 }
        // };

        int[][] matrix = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        // List<Integer> spiralOrder = spiralMatrix(matrix);
        // System.out.println(spiralOrder);
        // keySearc2DMat(matrix, 35);
        // System.out.println(numOccured(matrix, 7));
        System.out.println(sumOfSecRow(matrix));
    }

}
