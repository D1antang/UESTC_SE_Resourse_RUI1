package homework2.product;

public abstract class Product {
    protected int producerId;  // 生产者编号
    protected int productId;  // 产品编号

    public Product(int producerId, int productId) {
        this.producerId = producerId;
        this.productId = productId;
    }

    public abstract void process();  // 加工产品
    public abstract void display();  // 显示产品信息
}
