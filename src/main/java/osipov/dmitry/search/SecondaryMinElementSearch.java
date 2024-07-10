package osipov.dmitry.search;

public class SecondaryMinElementSearch {
    public static void main(String[] args) {
        int[] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(secondaryMin(array));
    }

    public static int secondaryMin(int[] array) {
        var min = Integer.MAX_VALUE;
        var secondary = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                secondary = min;
                min = array[i];
            } else if (array[i] < secondary && array[i] != min) {
                secondary = array[i];
            }
        }

        if (secondary == Integer.MAX_VALUE) {
            return min;
        }

        return secondary;
    }
}
