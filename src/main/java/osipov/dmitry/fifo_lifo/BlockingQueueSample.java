package osipov.dmitry.fifo_lifo;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueSample {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(() -> {
            var words = new String[] {"123", "abc", "qwerty", "queue", "stack", "array", "list"};

            for (int i = 0; i < words.length && !Thread.interrupted(); i++) {
                try {
                    Thread.sleep(5000);
                    queue.put(words[i]);
                    System.out.println("Producer записал в очередь " + words[i] + ", число элементов: " + queue.size());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            var builder = new StringBuilder();
            while (!Thread.interrupted()) {
                try {
                    builder.setLength(0);
                    Thread.sleep(8000);
                    builder.append(queue.take());
                    System.out.println("Consumer обработал из очереди " + builder.reverse() + ", число элементов: " +
                            queue.size());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        consumer.start();
    }
}
