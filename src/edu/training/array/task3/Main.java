package edu.training.array.task3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double ret1 = task1(new double[] {2, 8, 2, 6});
        System.out.println(ret1);

        int[] ret2 = task2(new int[] {5, 4, 4, 3, 8, 3, 9});
        System.out.println(Arrays.toString(ret2));

        int[] ret3 = task3(7, 4, 9, 5);
        System.out.println(Arrays.toString(ret3));

        int ret4 = task4(new int[] {4, 2, 4, 2, 5, 2, 4, 7, 7});
        System.out.println(ret4);

        int ret5 = task5(new int[] {5, 2, 7, 3, 4, 6, 2, 10});
        System.out.println(ret5);
    }

    public static double task1(double[] array) {
        double maxSum = array[0] + array[array.length - 1];
        for (int i = 1; i < array.length / 2; i++) {
            double sum = array[i] + array[array.length - 1 - i];
            maxSum = sum > maxSum ? sum : maxSum;
        }
        return maxSum;
    }

    public static int[] task2(int[] array) {
        int min = array[0];
        int minCount = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minCount = 1;
            } else if (array[i] == min) {
                minCount++;
            }
        }

        int[] newArray = new int[array.length - minCount];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != min) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    public static int[] task3(int firstCubeIndex, int firstCubeValue, int secondCubeIndex, int secondCubeValue) {
        int[] superLock = new int[10];
        superLock[firstCubeIndex] = firstCubeValue;
        superLock[secondCubeIndex] = secondCubeValue;

        int index1 = 0;
        while (superLock[index1] == 0) {
            index1++;
        }
        int index2 = index1 + 1;
        while (superLock[index2] == 0) {
            index2++;
        }

        int value = 10 - superLock[index1] - superLock[index2];

        if (index2 - index1 <= 2) {
            if (value > 6 || value < 1) {
                if (index1 - 2 >= 0) {
                    value = 10 - superLock[index1];
                    superLock[index1 - 2] = value / 2;
                    superLock[index1 - 1] = value % 2 == 0 ? value / 2 : value / 2 + 1;
                } else {
                    value = 10 - superLock[index2];
                    superLock[index2 + 1] = value / 2;
                    superLock[index2 + 2] = value % 2 == 0 ? value / 2 : value / 2 + 1;
                }
            } else {
                if (index2 - index1 == 1) {
                    if (index1 - 1 >= 0) {
                        superLock[index1 - 1] = value;
                    } else {
                        superLock[index2 + 1] = value;
                    }
                } else {
                    superLock[index1 + 1] = value;
                }
            }
        } else {
            value = 10 - superLock[index1];
            superLock[index1 + 1] = value / 2;
            superLock[index1 + 2] = superLock[index1] % 2 == 0 ? value / 2 : value / 2 + 1;
        }

        return superLock;
    }

    public static int task4(int[] array) {
        int[] frequency = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            int valCount = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == val) {
                    valCount++;
                }
            }
            frequency[i] = valCount;
        }

        int indexMaxFrequency = 0;
        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] > frequency[indexMaxFrequency]) {
                indexMaxFrequency = i;
            } else if (frequency[i] == frequency[indexMaxFrequency]) {
                indexMaxFrequency = array[i] < array[indexMaxFrequency] ? i : indexMaxFrequency;
            }
        }
        return array[indexMaxFrequency];
    }

    public static int task5(int[] array) {
        int minOdd = array[0];
        int maxEven = array[1];
        for (int i = 2; i < array.length; i++) {
            if ((i + 1) % 2 != 0) {
                minOdd = array[i] < minOdd ? array[i] : minOdd;
            } else {
                maxEven = array[i] > maxEven ? array[i] : maxEven;
            }
        }
        return minOdd + maxEven;
    }
}
