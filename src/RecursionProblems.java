public class RecursionProblems {

    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int sumArray(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + sumArray(arr, index + 1);
    }

    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true;
        if (arr[index] > arr[index + 1]) return false;
        return isSorted(arr, index + 1);
    }

    static int findMin(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        int minRest = findMin(arr, index + 1);
        return arr[index] < minRest ? arr[index] : minRest;
    }

    static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        int maxRest = findMax(arr, index + 1);
        return arr[index] > maxRest ? arr[index] : maxRest;
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci at position 6: " + fibonacci(6));

        int[] arr1 = {2, 4, 6, 8};
        System.out.println("Sum of array: " + sumArray(arr1, 0));

        int[] arr2 = {3, 5, 7, 9};
        System.out.println("Array is sorted: " + isSorted(arr2, 0));

        System.out.println("Minimum value: " + findMin(arr1, 0));
        System.out.println("Maximum value: " + findMax(arr1, 0));
    }
}
