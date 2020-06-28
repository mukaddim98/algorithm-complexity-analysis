/*
MatrixMult Solution
*/
/**
 This class tests the code for Lab2: Exercise3.
 It calls a method to multiply two square matrices of size n x n, and prints information about running time.
 It expands upon a framework provided by Srini.
 */
//Multiplication of two square matrices of size n X n each
import java.util.*;

public class MatrixMult{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // declare sentinel and element variable
        int n;
        double num;

        while ((n = sc.nextInt()) > 0) {
            num = sc.nextDouble();

            double[][] matrix1 = new double[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(matrix1[i], num);

            double[][] matrix2 = new double[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(matrix2[i], num);
            // This is Srini's template for timing execution
            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis(); // start timer
            double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
            endTime = System.currentTimeMillis(); // end timer
            executionTime = endTime - startTime;

            //message
            System.out.println(n + " " + executionTime);
        }
    }
    /** The method for multiplying two matrices */
    private static double[][] multiplyMatrix(double[][] m1, double[][] m2){
        int n = m1.length; // n is the dimension of the resultMatrix (nXn)
        double[][] resultMatrix = new double[n][n];
        for(int row = 0; row<n; row++){ // for each row of resultMatrix
            for(int col = 0; col<n; col++){ // for each column of resultMatrix
                for(int i = 0; i<n; i++) {
                    resultMatrix[row][col] += m1[row][i] * m2[i][col];
                }
            }
        }
        return resultMatrix;
    }
}


