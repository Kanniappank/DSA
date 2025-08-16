package builder;

public class Computer {
    private String RAM;
    private String HDD;
    private String bluetooth;
    private String graphicCard;

    Computer(String RAM, String HDD, String bluetooth, String graphicCard) {
        this.RAM = RAM;
        this.HDD = HDD;
        this.bluetooth = bluetooth;
        this.graphicCard = graphicCard;
    }

    public String toString(){
        return "Computer [RAM=" + RAM + ", HDD=" + HDD + ", Bluetooth=" + bluetooth + ", Graphic Card=" + graphicCard + "]";
    }

}
