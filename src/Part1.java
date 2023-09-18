import java.util.Random;
import java.util.Scanner;

public class Part1 {
    public static Random random = new Random();
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("Enter array length");
            int length = in.nextInt();
            int[] array;
            System.out.println("Do you want to input values manually?");
            System.out.println("m - manually, r - random values");
            in.nextLine();
            if (in.nextLine().equals("m")) {
                array = inputArray(length);
            } else {
                array = randomIntArray(length);
            }
            System.out.println("The array values are:");
            printArray(array);
            advancedSort(array);
            System.out.println("Array sorted:");
            printArray(array);
        } while (checkIfContinue());
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] inputArray(int length) {
        int[] array = new int[length];
        System.out.println("Enter the array members");
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    public static int[] randomIntArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
        }
        return array;
    }

    public static int[] sort(int[] array) {
        int numIterations = 0;
        int numSwaps = 0;
        for (int i = 0; i < array.length; i++) {
            numIterations += 1;
            for (int j = 0; j < array.length - 1; j++) {
                numIterations += 1;
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    numSwaps += 1;
                }
            }
        }
        System.out.println("Sorting array...");
        System.out.println("numIterations = " + numIterations);
        System.out.println("numSwaps = " + numSwaps);
        return array;
    }

    public static int[] advancedSort(int[] array) {
        int numIterations = 0;
        int numSwaps = 0;
        for (int i = 0; i < array.length; i++) {
            numIterations += 1;
            for (int j = 0; j < array.length; j += 2) {
                numIterations += 1;
                if (j + 1 < array.length && array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    numSwaps += 1;
                }
                else if (j - 1 > 0 && array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    numSwaps += 1;
                }
            }
        }
        System.out.println("Sorting array...");
        System.out.println("numIterations = " + numIterations);
        System.out.println("numSwaps = " + numSwaps);
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean checkIfContinue() {
        in.nextLine();
        System.out.println("Continue?");
        String yn = in.nextLine();
        return yn.equals("y") || yn.equals("Y");
    }
}
