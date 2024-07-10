package osipov.dmitry.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 1, 0, 21, 12, 4};
        mergeSort(array);  // best, average, worst - O(n * log(n))
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, array.length);
    }

    private static void mergeSort(int[] array, int length) {
        if (length <= 1) {
            return;
        }

        var middle = length / 2;
        var left = new int[middle];
        var right = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        for (int i = middle; i < length; i++) {
            right[i - middle] = array[i];
        }

        mergeSort(left, middle);
        mergeSort(right, length - middle);

        merge(array, left, right, middle, length - middle);
    }

    private static void merge(int[] array, int[] left, int[] right, int leftLength, int rigthLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rigthLength) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            array[k++] = left[i++];
        }

        while (j < rigthLength) {
            array[k++] = right[j++];
        }
    }
}
