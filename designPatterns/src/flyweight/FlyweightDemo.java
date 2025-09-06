public class FlyweightDemo {
    public static void main(String[] args) {
        IShape circle1=ShapeFactory.getCircle();
        circle1.draw("Red");

         IShape circle2=ShapeFactory.getCircle();
        circle1.draw("Blue");

         IShape circle3=ShapeFactory.getCircle();
        circle1.draw("Green");
    }
}
