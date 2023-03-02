package homework2.other;
import homework2.product.*;;

public abstract class Consumer {
    protected int consumerId;

    public Consumer(int consumerId) {
        this.consumerId = consumerId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void consume(Product product) {
        System.out.println("Consumer " + consumerId + " is consuming product ");
        product.display();
    }
}


