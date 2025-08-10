package state3.witoutState;

//reffrence https://www.youtube.com/watch?v=uQMiEP52YIg

public class TrafficLight {
    private String color;

    public TrafficLight() {
        this.color = "red";
    }

    public void next() {
        if (color.equalsIgnoreCase("red")) {
            color = "green";
            System.out.println("Light turned from Red to Green, Car goes");
        } else if (color.equalsIgnoreCase("green")) {
            color = "yellow";
            System.out.println("Lights Changed from green to yellow, Slow down");
        } else if (color.equalsIgnoreCase("yellow")) {
            color = "red";
            System.out.println("Light turned from Yellow to Red, Car stops");
        } else if (color.equalsIgnoreCase("")) {

        }
    }

    public String getColor(){
        return color;
    }
}
