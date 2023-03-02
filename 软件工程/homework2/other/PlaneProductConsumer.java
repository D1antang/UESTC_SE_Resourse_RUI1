package homework2.other;
import homework2.product.*;;

public class PlaneProductConsumer extends Consumer {
    public PlaneProductConsumer(int consumerId) {
        super(consumerId);
    }

    @Override
    public void consume(Product product) {
        if (product instanceof PlaneProduct) {
            super.consume(product);
        } else {
            System.out.println("Consumer " + super.consumerId + " can only consume plane products.");
        }
    }
}


