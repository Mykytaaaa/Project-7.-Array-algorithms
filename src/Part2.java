public class Part2 {
    public static void main(String[] args) {
        int[] array = Part1.randomIntArray(5);
        sortAndLog(array);
    }

    public static int[] sortAndLog(int[] array) {
        int numIterations = 0;
        for (int i = 0; i < array.length; i++) {
            numIterations += 1;
            System.out.println("Outer loop, iteration " + numIterations + ":");
            printArrayInLine(array);
            System.out.println("Inner loop:");
            for (int j = 0; j < array.length - 1; j++) {
                System.out.print("iteration " + j + ":");
                if (array[j] > array[j + 1]) {
                    Part1.swap(array, j, j + 1);
                }
                printArrayInLine(array);
            }
        }
        return array;
    }

    public static void printArrayInLine(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
}
