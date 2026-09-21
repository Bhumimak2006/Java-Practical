interface Notifier {
    void send(String message);
}

interface Urgent {
}

class EmailSender implements Notifier, Urgent {

    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSSender implements Notifier {

    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

public class NotificationDemo {
    public static void main(String[] args) {

        Notifier email = message ->
            System.out.println("Email: " + message);

        Notifier sms = message ->
            System.out.println("SMS: " + message);

        Notifier[] senders = {
            email,
            sms
        };

        String message = "Exam will start at 10 AM";

        System.out.println("Broadcasting Message:");

        for (Notifier sender : senders) {
            sender.send(message);
        }

        System.out.println("\nUrgent Notification:");

        Notifier urgentEmail = new EmailSender();

        urgentEmail.send(message);

        if (urgentEmail instanceof Urgent) {
            urgentEmail.send(message);
        }
    }
}