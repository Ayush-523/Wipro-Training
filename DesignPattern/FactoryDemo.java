package com.wipro.JavaBasics.DesignPattern;


public class FactoryDemo {
    public static void main(String[] args) {

        Notification notification;

        notification = NotificationFactory.getNotification("EMAIL");
        notification.send("Hello via Email!");

        notification = NotificationFactory.getNotification("SMS");
        notification.send("Hello via SMS!");

        notification = NotificationFactory.getNotification("PUSH");
        notification.send("Hello via Push Notification!");
    }
}

// Step 1: Common Interface
interface Notification {
    void send(String message);
}

// Step 2: Concrete Implementations

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// Step 3: Factory Class
class NotificationFactory {

    public static Notification getNotification(String type) {

        if (type == null) {
            return null;
        }

        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();

            case "SMS":
                return new SMSNotification();

            case "PUSH":
                return new PushNotification();

            default:
                throw new IllegalArgumentException("Invalid notification type");
        }
    }
}