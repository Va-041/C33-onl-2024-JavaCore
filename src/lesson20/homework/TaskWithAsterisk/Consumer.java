package lesson20.homework.TaskWithAsterisk;

public class Consumer implements Runnable {

    private final Shop shop;
    private final int[] purchasedProducts = new int[5];
    private int purchaseCount = 0;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (purchaseCount < 5) {
            try {
                while (!shop.hasProduct()) {
                    System.out.println("There is no product yet.");
                    Thread.sleep(100); //проверка каждые 100 мс
                }
                purchasedProducts[purchaseCount++] = shop.buyProduct();
                Thread.sleep(2000); //покупка продукта 2с
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nAll products are purchased: ");
        for (int product : purchasedProducts) {
            System.out.print(product + " ");
        }
        System.out.println();
    }
}
