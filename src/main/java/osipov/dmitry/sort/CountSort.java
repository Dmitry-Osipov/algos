package osipov.dmitry.sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = new int[] {10, 0, 1, 0, 9, 1, 12, 6, 8, 15};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void countSort(int[] array) {
        final int MAX_VALUE = 100;
        int[] count = new int[MAX_VALUE];
        for (int i : array) {
            count[i]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[index] = i;
                index++;
            }
        }
    }
}
