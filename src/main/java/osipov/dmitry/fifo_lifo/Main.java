package osipov.dmitry.fifo_lifo;

public class Main {
    public static void main(String[] args) {
        testQueue();
        System.out.println("------------------------------------------------");
        testStack();
    }

    private static void testQueue() {
        Queue<Integer> queue = new SimpleQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testStack() {
        Stack<Integer> stack = new SimpleStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
