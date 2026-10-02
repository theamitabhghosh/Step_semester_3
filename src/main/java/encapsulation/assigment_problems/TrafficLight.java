package encapsulation.assigment_problems;

public class TrafficLight {

    private String state;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.state = "RED";
    }

    public void change() {
        if (state.equals("RED")) {
            state = "GREEN";
        } else if (state.equals("GREEN")) {
            state = "YELLOW";
        } else if (state.equals("YELLOW")) {
            state = "RED";
        }
    }

    public String getState() {
        return state;
    }

    public static void main(String[] args) {

        TrafficLight light = new TrafficLight("TL-1");

        System.out.println("Initial State: " + light.getState());

        light.change();
        System.out.println("After Change 1: " + light.getState());

        light.change();
        System.out.println("After Change 2: " + light.getState());

        light.change();
        System.out.println("After Change 3: " + light.getState());
    }
}