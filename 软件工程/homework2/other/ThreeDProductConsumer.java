package homework2.other;
import homework2.product.*;

public class ThreeDProductConsumer extends Consumer {
    public ThreeDProductConsumer(int consumerId) {
        super(consumerId);
    }

    @Override
    public void consume(Product product) {
        if (product instanceof ThreeDProduct) {
            super.consume(product);
        } else {
            System.out.println("Consumer " + super.consumerId + " can only consume 3D products.");
        }
    }
}
