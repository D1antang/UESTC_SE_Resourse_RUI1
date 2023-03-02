package homework2.other;

import java.util.LinkedList;
import java.util.Queue;

import homework2.product.*;

public class Warehouse {
    private double totalArea ;   // 总面积
    private double totalVolume ; // 总容积
    private double remainingArea = 1000;   // 剩余面积
    private double remainingVolume = 1000; // 剩余容积
    private Queue<PlaneProduct> planeProducts;   // 平面产品队列
    private Queue<ThreeDProduct> threeDProducts; // 三维产品队列

    public Warehouse(double totalArea, double totalVolume) {
        this.totalArea = totalArea;
        this.totalVolume = totalVolume;
        this.remainingArea = totalArea;
        this.remainingVolume = totalVolume;
        this.planeProducts = new LinkedList<PlaneProduct>();
        this.threeDProducts = new LinkedList<ThreeDProduct>();

        // 添加两个默认的 PlaneProduct 和两个默认的 ThreeDProduct
        PlaneProduct defaultPlaneProduct1 = new Triangle(11,12, 10, 10);
        PlaneProduct defaultPlaneProduct2 = new Rectangle(10,10, 20, 20);
        planeProducts.offer(defaultPlaneProduct1);
        planeProducts.offer(defaultPlaneProduct2);
        remainingArea -= defaultPlaneProduct1.area() + defaultPlaneProduct2.area();

        ThreeDProduct defaultThreeDProduct1 = new Cube( 13, 10, 10);
        ThreeDProduct defaultThreeDProduct2 = new CircleCylinder(12, 20, 20, 20);
        threeDProducts.offer(defaultThreeDProduct1);
        threeDProducts.offer(defaultThreeDProduct2);
        remainingVolume -= defaultThreeDProduct1.volume() + defaultThreeDProduct2.volume();
    }

    public void storeProduct(Product product) {
        if (product instanceof PlaneProduct) {
            PlaneProduct planeProduct = (PlaneProduct) product;
            if (planeProduct.area() <= remainingArea) {
                planeProducts.offer(planeProduct);
                remainingArea -= planeProduct.area();
            } else {
                System.out.println("平面产品存储失败：仓库空间不足。");
            }
        } else if (product instanceof ThreeDProduct) {
            ThreeDProduct threeDProduct = (ThreeDProduct) product;
            if (threeDProduct.volume() <= remainingVolume) {
                threeDProducts.offer(threeDProduct);
                remainingVolume -= threeDProduct.volume();
            } else {
                System.out.println("三维产品存储失败：仓库空间不足。");
            }
        } else {
            System.out.println("存储失败：未知产品类型。");
        }
    }

    public Product takeProduct() {
        if (!planeProducts.isEmpty()) {
            return planeProducts.poll();
        } else if (!threeDProducts.isEmpty()) {
            return threeDProducts.poll();
        } else {
            System.out.println("仓库已空，无法取出产品。");
            return null;
        }
    }

    public double getRemainingArea() {
        return remainingArea;
    }

    public double getRemainingVolume() {
        return remainingVolume;
    }
}
