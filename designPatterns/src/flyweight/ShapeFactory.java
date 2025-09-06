
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, IShape> shapeMap = new HashMap<>();

    public static IShape getCircle() {
        IShape circle = shapeMap.get("Circle");
        if (circle == null) {
            circle = new Circle();
            shapeMap.put("Circle", circle);
            System.out.println("Creating new circle Object");
        }
        return circle;

    }
}
