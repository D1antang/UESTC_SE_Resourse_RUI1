package homework2.product;

public class Rectangle extends PlaneProduct {
    private double length;
    private double width;

    public Rectangle(int producerId, int productId, double length, double width) {
        super(producerId, productId);
        this.length = length;
        this.width = width;
    }

    @Override
    public void process() {
        // 加工矩形产品
    }

    @Override
    public void display() {
        // 显示矩形信息
    }

    @Override
    public double area() {
        return length * width;
    }
}
