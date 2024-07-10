package osipov.dmitry.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // Массив обязательно должен быть отсортирован
        System.out.println(binarySearch(array, 9));  // O(log(n))
    }

    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int value, int minPos, int maxPos) {
        if (maxPos < minPos) {
            return -1;
        }

        int midpoint = (maxPos - minPos) / 2 + minPos;

        if (array[midpoint] == value) {
            return midpoint;
        }

        return array[midpoint] < value ? binarySearch(array, value, midpoint + 1, maxPos) :
                binarySearch(array, value, minPos, midpoint - 1);
    }
}
