package homework2.product;

public class Trapezoid extends PlaneProduct {
    private double top;
    private double bottom;
    private double height;

    public Trapezoid(int producerId, int productId, double top, double bottom, double height) {
        super(producerId, productId);
        this.top = top;
        this.bottom = bottom;
        this.height = height;
    }

    @Override
    public void process() {
        // 加工梯形产品
    }

    @Override
    public void display() {
        // 显示梯形信息
    }

    @Override
    public double area() {
        return (top + bottom) * height / 2;
    }
}

