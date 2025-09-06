public class Circle implements IShape {
    private String shapeType = "Circle";

    @Override
    public void draw(String color) {
        System.out.println("Drawing " + shapeType + " in color " + color);
    }

}
