package osipov.dmitry.search;

public class MinElementSearch {
    public static void main(String[] args) {
        int[] array = new int[] {64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(minSearch(array));  // O(n)
    }

    public static int minSearch(int[] array) {
        var minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        return minValue;
    }
}
