package builder;

public class BuilderDemo {
    public static void main(String[] args) {
        Computer gamingComputer= new ComputerBuilder("16GB","500GB").configureBluetooth("SONY").configureGraphicCard("Intel").build();
        System.out.println(gamingComputer.toString());
    }
}
