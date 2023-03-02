package homework2.product;

public class Triangle extends PlaneProduct {
    private double base;
    private double height;

    public Triangle(int producerId, int productId, double base, double height) {
        super(producerId, productId);
        this.base = base;
        this.height = height;
    }

    @Override
    public void process() {
        // 加工三角形产品
    }

    @Override
    public void display() {
        // 显示三角形信息
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

