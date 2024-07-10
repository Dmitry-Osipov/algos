package osipov.dmitry.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 10, 0, 12, 1, 5, 4, 9, 6};
        quickSort(nums);  // best, average - O(n * log(n)), worst - O(n^2)
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int startPos, int endPos) {
        if (startPos < endPos) {
            int partitionIndex = partition(array, startPos, endPos);
            quickSort(array, startPos, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, endPos);
        }
    }

    private static int partition(int[] array, int startPos, int endPos) {
        int pivot = array[endPos];
        int i = startPos - 1;

        for (int j = startPos; j < endPos; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[endPos];
        array[endPos] = temp;
        return i + 1;
    }
}
