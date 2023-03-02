package homework2.product;

public class CircleCylinder extends ThreeDProduct {
    private double radius;
    private double height;

    public CircleCylinder(int producerId, int productId, double radius, double height) {
        super(producerId, productId);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public void process() {
        // 加工圆柱体产品
    }

    @Override
    public void display() {
        // 显示圆柱体信息
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }
}
