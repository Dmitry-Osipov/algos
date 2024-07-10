package osipov.dmitry.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = new int[] {0, 10, 0, 12, 1, 5, 4, 9, 6};
        heapSort(numbers);  // best, average, worst - O(n * log(n))
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {  // Построение кучи (перегруппировка массива)
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {  // Один за другим извлекаем элементы из кучи
            int temp = array[0];  // Перемещаем текущий корень в конец
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);  // Вызываем метод на уменьшеной куче
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, heapSize, largest);
        }
    }
}
