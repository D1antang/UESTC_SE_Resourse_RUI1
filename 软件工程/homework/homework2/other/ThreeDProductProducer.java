package homework2.other;

import homework2.product.ThreeDProduct;

public abstract class ThreeDProductProducer extends Producer {
    public ThreeDProductProducer(int producerId) {
        super(producerId);
    }

    @Override
    public ThreeDProduct build() {
        ThreeDProduct product = createProduct();
        return product;
    }
    
    public abstract ThreeDProduct createProduct();
}
