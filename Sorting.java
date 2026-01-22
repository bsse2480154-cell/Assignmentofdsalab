//Question no 5
public class Sorting {

    public static void mergesort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        mergesort(arr, low, mid);
        mergesort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp[k++] = arr[left++];
            else
                temp[k++] = arr[right++];
        }

        while (left <= mid)
            temp[k++] = arr[left++];

        while (right <= high)
            temp[k++] = arr[right++];

        for (int i = 0; i < temp.length; i++)
            arr[low + i] = temp[i];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8};
        int[] arr2 = {5, 1, 4, 2, 8};

        // Merge Sort
        System.out.print("Original array for Merge Sort: ");
        for (int i = 0; i < arr1.length; i++) System.out.print(arr1[i] + " ");
        System.out.println();

        mergesort(arr1, 0, arr1.length - 1);

        System.out.print("Array after Merge Sort: ");
        for (int i = 0; i < arr1.length; i++) System.out.print(arr1[i] + " ");
        System.out.println("\n");

        // Quick Sort
        System.out.print("Original array for Quick Sort: ");
        for (int i = 0; i < arr2.length; i++) System.out.print(arr2[i] + " ");
        System.out.println();

        quickSort(arr2, 0, arr2.length - 1);

        System.out.print("Array after Quick Sort: ");
        for (int i = 0; i < arr2.length; i++) System.out.print(arr2[i] + " ");
        System.out.println();

        System.out.println("\n Comparison between mergesort and quick sort");

        System.out.println("Time Complexity:");
        System.out.println("Merge Sort runs in O(n log n) in best, average, and worst cases.");
        System.out.println("Quick Sort runs in O(n log n) on average, but O(n^2) in the worst case.");

        System.out.println("\nSpace Complexity:");
        System.out.println("Merge Sort requires extra memory of O(n) for temporary arrays.");
        System.out.println("Quick Sort works in-place and uses O(log n) space due to recursion.");

        System.out.println("\nConclusion:");
        System.out.println("Merge Sort is stable and predictable but uses more memory.");
        System.out.println("Quick Sort is faster in practice but has a worst-case risk.");

    }
}
