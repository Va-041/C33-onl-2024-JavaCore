package lesson20.homework.TaskWithAsterisk;

public class Producer implements Runnable {

    private final Shop shop;
    private static int productCount = 1;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {

        while (productCount <= 10) {
            try {
                shop.addProduct(productCount++);
                Thread.sleep(200); //производство продукта 0,2с
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
