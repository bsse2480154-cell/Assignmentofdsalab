    public class RecursionProblems {

        public static void main(String[] args) {

            // Factorial of 5
            int n = 5;
            System.out.println("Factorial of " + n + " = " + factorial(n));

            // Fibonacci number at position 6
            int pos = 6;
            System.out.println("Fibonacci number at position " + pos + " = " + fibonacci(pos));

            // Sum of array elements {2, 4, 6, 8}
            int[] arr = {2, 4, 6, 8};
            System.out.println("Sum of array elements = " + sumArray(arr, arr.length));

            // Check whether the array {3, 5, 7, 9} is sorted
            int[] arr2 = {3, 5, 7, 9};
            System.out.println("Array is sorted? " + isSorted(arr2, arr2.length));

            // Find minimum and maximum element of an array
            int[] arr3 = {10, 5, 30, 2, 50};
            System.out.println("Minimum element = " + findMin(arr3, arr3.length));
            System.out.println("Maximum element = " + findMax(arr3, arr3.length));
        }

        // Factorial
        static int factorial(int n) {
            if (n == 0) return 1; // Base case
            return n * factorial(n - 1); // Recursive case
        }

        // Fibonacci
        static int fibonacci(int n) {
            if (n == 0) return 0; // Base case
            if (n == 1) return 1; // Base case
            return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
        }

        // Sum of array elements
        static int sumArray(int[] arr, int n) {
            if (n == 1) return arr[0]; // Base case
            return sumArray(arr, n - 1) + arr[n - 1]; // Recursive case
        }

        // Check if array is sorted
        static boolean isSorted(int[] arr, int n) {
            if (n == 0 || n == 1) return true; // Base case
            if (arr[n - 2] > arr[n - 1]) return false;
            return isSorted(arr, n - 1); // Recursive case
        }

        // Find minimum element
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

