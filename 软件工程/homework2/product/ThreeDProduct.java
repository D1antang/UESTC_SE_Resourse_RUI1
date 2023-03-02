package homework2.product;

public abstract class ThreeDProduct extends Product {
    final int type = 2;
    public ThreeDProduct(int producerId, int productId) {
        super(producerId, productId);
    }
    public abstract double volume(); // 计算体积
}