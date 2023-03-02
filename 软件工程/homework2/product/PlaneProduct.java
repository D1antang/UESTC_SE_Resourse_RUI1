package homework2.product;

public abstract class PlaneProduct extends Product {
    final int type = 1;
    public PlaneProduct(int producerId, int productId) {
        super(producerId, productId);
    }

    public abstract double area();  // 计算面积
}

