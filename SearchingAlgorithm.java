public class SearchingAlgorithm {

    // Array to search
    static int[] arr = {3, 8, 12, 20, 25, 30};

    public static void main(String[] args) {
        System.out.println("Array: ");
        displayArray(arr);

        // 1. Iterative Binary Search to find 20
        int target1 = 20;
        int index1 = binarySearchIterative(arr, target1);
        System.out.println("\nIterative Binary Search: " + target1 + " found at index: " + index1);

        // 2. Recursive Binary Search to find 25
        int target2 = 25;
        int index2 = binarySearchRecursive(arr, target2, 0, arr.length - 1);
        System.out.println("Recursive Binary Search: " + target2 + " found at index: " + index2);

        // 3. Recursive Linear Search to find 12
        int target3 = 12;
        int index3 = linearSearchRecursive(arr, target3, 0);
        System.out.println("Recursive Linear Search: " + target3 + " found at index: " + index3);

        // 4. Find minimum and maximum using recursion
        int min = findMin(arr, arr.length);
        int max = findMax(arr, arr.length);
        System.out.println("Minimum value in array: " + min);
        System.out.println("Maximum value in array: " + max);

        // Extra: Time & space complexity notes
        System.out.println();
        System.out.println("- Binary search requires a sorted array because it makes decisions based on the assumption that elements are in order. Without sorting the divide and conquer logic fails and the search will not be correct.");
        System.out.println("- Iterative Binary Search: Time O(log n), Space O(1)");
        System.out.println("- Recursive Binary Search: Time O(log n), Space O(log n) due to recursion stack");
        System.out.println("- Recursive Linear Search: Time O(n), Space O(n)");
        System.out.println("- Min/Max using recursion: Time O(n), Space O(n)");
    }

    // Display array
    static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Iterative Binary Search
    static int binarySearchIterative(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // not found
    }

    // Recursive Binary Search
    static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) return -1; // base case: not found
        int mid = left + (right - left) / 2;
        if (array[mid] == target) return mid;
        else if (array[mid] < target) return binarySearchRecursive(array, target, mid + 1, right);
        else return binarySearchRecursive(array, target, left, mid - 1);
    }

    // Recursive Linear Search
    static int linearSearchRecursive(int[] array, int target, int index) {
        if (index >= array.length) return -1; // base case: not found
        if (array[index] == target) return index; // found
        return linearSearchRecursive(array, target, index + 1); // recursive case
    }

    static int findMin(int[] arr, int n) {
        if (n == 1) return arr[0]; // Base case
        int minRest = findMin(arr, n - 1); // Recursive case
        if (arr[n - 1] < minRest) {
            return arr[n - 1];
        } else {
            return minRest;
        }
    }

    // Find maximum element
    static int findMax(int[] arr, int n) {
        if (n == 1) return arr[0]; // Base case
        int maxRest = findMax(arr, n - 1); // Recursive case
        if (arr[n - 1] > maxRest) {
            return arr[n - 1];
        } else {
            return maxRest;
        }
    }
}
