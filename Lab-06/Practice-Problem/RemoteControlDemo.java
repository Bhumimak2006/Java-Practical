interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}


interface SwitchRule {
    boolean canSwitchOn(String device, int hour);
}

public class RemoteControlDemo {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        System.out.println("Toggling Devices:");

        for (Switchable device : devices) {
            device.toggle();
        }

        SwitchRule rule1 = new SwitchRule() {
            public boolean canSwitchOn(String device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        System.out.println("\nUsing Anonymous Class:");

        if (rule1.canSwitchOn("Fan", 10)) {
            System.out.println("Fan can be switched ON");
        } else {
            System.out.println("Fan cannot be switched ON");
        }

        SwitchRule rule2 = (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println("\nUsing Lambda:");

        if (rule2.canSwitchOn("Light", 23)) {
            System.out.println("Light can be switched ON");
        } else {
            System.out.println("Light cannot be switched ON");
        }
    }
}