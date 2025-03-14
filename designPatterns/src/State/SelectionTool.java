package State;

public class SelectionTool implements Tool{
    @Override
    public void mouseUp() {
        System.out.println("Drawn a Rectangular box");
    }

    @Override
    public void mouseDown() {
        System.out.println("Selection Icon");
    }
}
