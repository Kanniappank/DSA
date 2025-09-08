package builder;

public class ComputerBuilder {

    private String RAM;
    private String HDD;
    private String bluetooth;
    private String graphicsCard;

    public ComputerBuilder(String RAM, String HDD) {
        this.RAM = RAM;
        this.HDD = HDD;
    }

    public ComputerBuilder configureGraphicCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public ComputerBuilder configureBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
        return this;
    }

    public Computer build() {
        return new Computer(RAM,HDD,bluetooth,graphicsCard);
    }

}
