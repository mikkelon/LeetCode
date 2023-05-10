import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralOrder(matrix2));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        double turns = Math.min(matrix.length, matrix[0].length) * 1.0 / 2;
        boolean vertical = matrix.length > matrix[0].length;
        int turn = 0;

        while (turn < turns) {

            if (turns - turn > 0.5) {
                // Top side of spiral
                for (int i = turn; i < matrix[turn].length - turn; i++) {
                    list.add(matrix[turn][i]);
                }

                // Right side of spiral
                for (int i = turn + 1; i < matrix.length - turn; i++) {
                    list.add(matrix[i][matrix[i].length - 1 - turn]);
                }

                // Bottom side of spiral
                for (int i = matrix[turn].length - 2 - turn; i >= turn; i--) {
                    list.add(matrix[matrix.length - 1 - turn][i]);
                }

                // Left side of spiral
                for (int i = matrix.length - 2 - turn; i > turn; i--) {
                    list.add(matrix[i][turn]);
                }
            } else {
                // Add whatever is left of the matrix
                if (vertical) { // if the matrix is higher than it is wide
                    for (int i = turn; i < matrix.length - turn; i++) {
                        list.add(matrix[i][turn]);
                    }
                } else { // if the matrix is wider than it is large, or if it is a square.
                    for (int i = turn; i < matrix[turn].length - turn; i++) {
                        list.add(matrix[turn][i]);
                    }
                }
            }
            turn++;
        }
        return list;
    }
}
