package lesson20.homework.TaskWithAsterisk;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Shop {

    private final Queue<Integer> store = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {

        System.out.println("\nStart working...\n\n");

        Shop shop = new Shop();
        Thread producer = new Thread(new Producer(shop));
        Thread consumer = new Thread(new Consumer(shop));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void addProduct(int product) throws InterruptedException {
        while (store.size() == 3) {
            System.out.println("The store is full, the manufacturer is waiting...");
            displayStore();
            wait();
        }
        store.add(product);
        System.out.println("The manufacturer added the product: " + product);
        displayStore();
        notifyAll();
    }

    public synchronized int buyProduct() throws InterruptedException {
        while (store.isEmpty()) {
            wait();
        }
        int product = store.poll();
        System.out.println("\nThe customer bought the product: " + product);
        displayStore();
        notifyAll();
        return product;
    }

    public synchronized boolean hasProduct() {
        return !store.isEmpty();
    }

    public synchronized void displayStore() {
        System.out.println("Store status: " + store);
    }
}