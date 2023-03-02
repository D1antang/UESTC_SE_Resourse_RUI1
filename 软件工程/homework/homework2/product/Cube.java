package homework2.product;

public class Cube extends ThreeDProduct {
    private double length;

    public Cube(int producerId, int productId, double length) {
        super(producerId, productId);
        this.length = length;
    }

    @Override
    public void process() {
        // 加工长方体产品
    }

    @Override
    public void display() {
        // 显示长方体信息
    }

    @Override
    public double volume() {
        return length * length * length;
    }
}
