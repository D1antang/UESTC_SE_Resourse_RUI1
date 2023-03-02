package homework2.other;

import homework2.product.Product;

public class ConsumerRunnable implements Runnable {
    private final Consumer consumer;
    private final Warehouse warehouse;

    public ConsumerRunnable(Consumer consumer, Warehouse warehouse) {
        this.consumer = consumer;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            Product product = warehouse.takeProduct();
            if (product != null) {
                consumer.consume(product);
                System.out.println("Consumer " + consumer.getConsumerId() + " consumed " + product);
            }
            try {
                Thread.sleep((long) (Math.random() * 1000)); // 模拟消费的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
