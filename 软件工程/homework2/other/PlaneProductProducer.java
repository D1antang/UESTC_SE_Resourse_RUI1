package homework2.other;

import homework2.product.PlaneProduct;

public abstract class PlaneProductProducer extends Producer {
    public PlaneProductProducer(int producerId) {
        super(producerId);
    }

    @Override
    public PlaneProduct build() {
        PlaneProduct product = createProduct();
        return product;
    }
    
    public abstract PlaneProduct createProduct();
}
