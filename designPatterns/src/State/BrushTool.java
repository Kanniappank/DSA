package State;

public class BrushTool implements Tool{
    @Override
    public void mouseUp() {
        System.out.println("Drawn a painted line");
    }

    @Override
    public void mouseDown() {
        System.out.println("Brush Icon");
    }
}
