package edu.training.array.task4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] array1 = task1(6);
        Arrays.stream(array1).forEach(row -> System.out.println(Arrays.toString(row)));

        int[][] array2 = task2(6);
        Arrays.stream(array2).forEach(row -> System.out.println(Arrays.toString(row)));

        int[][] array3 = task3(6);
        Arrays.stream(array3).forEach(row -> System.out.println(Arrays.toString(row)));

        double[][] array4 = task4(new double[] {1, 2, 3});
        Arrays.stream(array4).forEach(row -> System.out.println(Arrays.toString(row)));

        int[][] array5 = task5(new int[][] {{1, 2}, {3, 4}, {5, 6}}, new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}});
        Arrays.stream(array5).forEach(row -> System.out.println(Arrays.toString(row)));

        int[][] array6 = task6(9);
        Arrays.stream(array6).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public static int[][] task1(int n) {
        int[][] array = new int[n][n];
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0, val = n; i < n; i++, val--) {
            firstArray[i] = i + 1;
            secondArray[i] = val;
        }
        for (int i = 0; i < n; i += 2) {
            array[i] = firstArray;
            array[i + 1] = secondArray;
        }
        return array;
    }

    public static int[][] task2(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][i] = (i + 1) * (i + 2);
        }
        return array;
    }

    public static int[][] task3(int n) {
        int[][] array = new int[n][n];
        for (int upperRow = 0, downRow = n - 1; upperRow < n / 2; upperRow++, downRow--) {
            for (int j = upperRow; j < n - upperRow; j++) {
                array[upperRow][j] = 1;
                array[downRow][j] = 1;
            }
        }
        return array;
    }

    public static double[][] task4(double[] array) {
        double[][] squareArray = new double[array.length][array.length];
        squareArray[0] = array;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                squareArray[i][j] = squareArray[i - 1][j] * array[j];
            }
        }
        return squareArray;
    }

    public static int[][] task5(int[][] firstArray, int[][] secondArray) {
        int[][] multipliedArray = new int[firstArray.length][secondArray[0].length];
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray[0].length; j++) {
                for (int k = 0; k < firstArray[0].length; k++) {
                    multipliedArray[i][j] += firstArray[i][k] * secondArray[k][j];
                }
            }
        }
        return multipliedArray;
    }

    public static int[][] task6(int n) {
        int[][] magicSquare = new int[n][n];

        if (n > 2 && n % 2 > 0) {
//            int magicNumber = n * (n * n + 1) / 2;
//            System.out.println("magic number: " + magicNumber);

            int row = n - 1;
            int col = n / 2;
            magicSquare[row][col] = 1;

            for (int i = 2; i <= n * n; i++) {
                if (magicSquare[(row + 1) % n][(col + 1) % n] == 0) {
                    row = (row + 1) % n;
                    col = (col + 1) % n;
                } else {
                    row = (row - 1 + n) % n;
                }
                magicSquare[row][col] = i;
            }
        }

        return magicSquare;
    }
}
