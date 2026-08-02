public class BinarySearchMethod {

    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};

                int key = 50;

        int result = binarySearch(arr, key);

        if (result != -1)
            System.out.println("Element found at position: " + (result + 1));
        else
            System.out.println("Element not found");
    }
}
