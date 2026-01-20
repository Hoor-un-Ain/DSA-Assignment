public class SearchingAlgorithms {

    // Iterative Binary Search
    public static int iterativeBinarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Recursive Binary Search
    public static int recursiveBinarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return recursiveBinarySearch(arr, target, mid + 1, right);
        else return recursiveBinarySearch(arr, target, left, mid - 1);
    }

    // Recursive Linear Search
    public static int recursiveLinearSearch(int[] arr, int target, int index) {
        if (index >= arr.length) return -1;
        if (arr[index] == target) return index;
        return recursiveLinearSearch(arr, target, index + 1);
    }

    // Recursive Min
    public static int recursiveMin(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        int minRest = recursiveMin(arr, index + 1);
        return arr[index] < minRest ? arr[index] : minRest;
    }

    // Recursive Max
    public static int recursiveMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        int maxRest = recursiveMax(arr, index + 1);
        return arr[index] > maxRest ? arr[index] : maxRest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 20, 25, 30};

        // Iterative Binary Search
        int idx1 = iterativeBinarySearch(arr, 20);
        System.out.println("Iterative Binary Search for 20: " + (idx1 != -1 ? "Found at index " + idx1 : "Not found"));

        // Recursive Binary Search
        int idx2 = recursiveBinarySearch(arr, 25, 0, arr.length - 1);
        System.out.println("Recursive Binary Search for 25: " + (idx2 != -1 ? "Found at index " + idx2 : "Not found"));

        // Recursive Linear Search
        int idx3 = recursiveLinearSearch(arr, 12, 0);
        System.out.println("Recursive Linear Search for 12: " + (idx3 != -1 ? "Found at index " + idx3 : "Not found"));

        // Recursive Min & Max
        int minVal = recursiveMin(arr, 0);
        int maxVal = recursiveMax(arr, 0);
        System.out.println("Minimum value: " + minVal);
        System.out.println("Maximum value: " + maxVal);

        System.out.println("\nNote: Binary search requires sorted array because it compares mid element to target and eliminates half of search space at each step.");
    }
}
