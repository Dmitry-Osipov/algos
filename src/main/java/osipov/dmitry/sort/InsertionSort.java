package osipov.dmitry.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] {1, 0, 12, 42, 73, 11, 98, 23, 54, 15, 78, 7};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > value) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = value;
        }
    }
}
