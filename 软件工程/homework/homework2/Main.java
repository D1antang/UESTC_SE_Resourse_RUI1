package homework2;

import homework2.other.*;
import homework2.product.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("2021090920004 詹锐艺");
        Warehouse warehouse = new Warehouse(1000, 1000);

        ThreeDProductProducer threeDProductProducer1 = new ThreeDProductProducer(1) {
            @Override
            public ThreeDProduct createProduct() {
                return new Cube(10, 10, 10);
            }
        };
        ThreeDProductProducer threeDProductProducer2 = new ThreeDProductProducer(2) {
            @Override
            public ThreeDProduct createProduct() {
                return new CircleCylinder(3, 8, 5, 10);
            }
        };

        PlaneProductProducer planeProductProducer1 = new PlaneProductProducer(3) {
            @Override
            public PlaneProduct createProduct() {
                return new Triangle(1, 10, 10, 10);
            }
        };
        PlaneProductProducer planeProductProducer2 = new PlaneProductProducer(4) {
            @Override
            public PlaneProduct createProduct() {
                return new Rectangle(2, 20, 20, 20);
            }
        };

        ThreeDProductConsumer threeDProductConsumer1 = new ThreeDProductConsumer(1);
        ThreeDProductConsumer threeDProductConsumer2 = new ThreeDProductConsumer(2);

        PlaneProductConsumer planeProductConsumer1 = new PlaneProductConsumer(3);
        PlaneProductConsumer planeProductConsumer2 = new PlaneProductConsumer(4);

        Thread[] threads = new Thread[8];

        threads[0] = new Thread(new ProducerRunnable(threeDProductProducer1, warehouse));
        threads[1] = new Thread(new ProducerRunnable(threeDProductProducer2, warehouse));
        threads[2] = new Thread(new ProducerRunnable(planeProductProducer1, warehouse));
        threads[3] = new Thread(new ProducerRunnable(planeProductProducer2, warehouse));
        threads[4] = new Thread(new ConsumerRunnable(threeDProductConsumer1, warehouse));
        threads[5] = new Thread(new ConsumerRunnable(threeDProductConsumer2, warehouse));
        threads[6] = new Thread(new ConsumerRunnable(planeProductConsumer1, warehouse));
        threads[7] = new Thread(new ConsumerRunnable(planeProductConsumer2, warehouse));

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
