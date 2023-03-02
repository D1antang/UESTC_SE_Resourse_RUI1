package homework2.product;

public class Sphere extends ThreeDProduct {
    private double radius;

    public Sphere(int producerId, int productId, double radius) {
        super(producerId, productId);
        this.radius = radius;
    }

    @Override
    public void process() {
        // 加工球体产品
    }

    @Override
    public void display() {
        // 显示球体信息
    }

    @Override
    public double volume() {
        return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
    }
}
