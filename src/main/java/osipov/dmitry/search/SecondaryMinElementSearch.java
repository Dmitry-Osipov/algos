package osipov.dmitry.search;

public class SecondaryMinElementSearch {
    public static void main(String[] args) {
        int[] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(secondaryMin(array));
    }

    public static int secondaryMin(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        var min = array[0];
        var secondary = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                secondary = min;
                min = array[i];
            } else if (array[i] < secondary && array[i] != min) {
                secondary = array[i];
            }
        }

        return secondary;
    }
}
