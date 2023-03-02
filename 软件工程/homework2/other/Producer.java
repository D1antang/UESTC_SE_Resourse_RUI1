package homework2.other;

import homework2.product.Product;

public abstract class Producer {
    private int producerId;
    private int productCount = 0;

    public Producer(int producerId) {
        this.producerId = producerId;
    }

    public abstract Product build(); // 生产产品

    protected int nextProductId() {
        return ++productCount;
    }

    public int getProducerId() {
        return producerId;
    }
}
