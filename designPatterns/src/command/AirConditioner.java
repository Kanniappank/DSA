package command;

public class AirConditioner {
    boolean isNo;
    int temperature;

    public void turnNoAc() {
        System.out.println("AC is turned ON");
        isNo = true;
    }

    public void turnOffAc(){
        System.out.println("AC is turned OFF");
        isNo = false;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature is set to " + temperature);
    }
}
