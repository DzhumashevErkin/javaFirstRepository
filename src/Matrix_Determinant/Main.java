package Matrix_Determinant;

public class Main {

    public static int determinant(int[][] matrix) {
        return determinantOfMatrix(matrix,matrix.length,matrix.length);
    }
    static void getCofactor(int mat[][], int temp[][],
                            int p, int q, int n)
    {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static int determinantOfMatrix(int mat[][], int n,int M)
    {
        int D = 0;

        if (n == 1)
            return mat[0][0];

        int temp[][] = new int[M][M];

        int sign = 1;

        for (int f = 0; f < n; f++) {
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1,M);

            sign = -sign;
        }

        return D;
    }
    public static void main(String[] args)
    {

    }
}
