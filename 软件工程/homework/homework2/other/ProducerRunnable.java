package homework2.other;

import homework2.product.Product;

public class ProducerRunnable implements Runnable {
    private final Producer producer;
    private final Warehouse warehouse;

    public ProducerRunnable(Producer producer, Warehouse warehouse) {
        this.producer = producer;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            Product product = producer.build();
            warehouse.storeProduct(product);
            System.out.println("Producer " + producer.getProducerId() + " produced " + product);
            try {
                Thread.sleep((long) (Math.random() * 1000)); // 模拟生产的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
