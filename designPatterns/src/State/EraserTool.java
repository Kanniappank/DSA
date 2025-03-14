package State;

public class EraserTool implements Tool{
    @Override
    public void mouseUp() {
        System.out.println("Erased a line");
    }

    @Override
    public void mouseDown() {
        System.out.println("Eraser icon");
    }
}
