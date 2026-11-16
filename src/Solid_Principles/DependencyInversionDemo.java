package Solid_Principles;

// 1. Abstraction shared by both high-level and low-level modules
interface MessageChannel {
    void dispatch(String recipient, String message);
}

// 2. Low-level concrete implementations
class EmailChannel implements MessageChannel {
    @Override
    public void dispatch(String recipient, String message) {
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}

class SlackChannel implements MessageChannel {
    @Override
    public void dispatch(String recipient, String message) {
        System.out.println("Slack DM sent to @" + recipient + ": " + message);
    }
}

// 3. High-level module: Completely decoupled from Email or Slack specifics!
class AlertManager {
    private final MessageChannel channel;

    // Dependency Injection via constructor
    public AlertManager(MessageChannel channel) {
        this.channel = channel;
    }

    public void triggerCriticalAlert(String user, String issue) {
        channel.dispatch(user, "CRITICAL ALERT: " + issue);
    }
}

public class DependencyInversionDemo {
    public static void main(String[] args) {
        // Wiring low-level implementation into high-level service at runtime
        AlertManager emailAlerts = new AlertManager(new EmailChannel());
        emailAlerts.triggerCriticalAlert("vishal@example.com", "Disk usage exceeded 90%");

        AlertManager slackAlerts = new AlertManager(new SlackChannel());
        slackAlerts.triggerCriticalAlert("vishal_dev", "Production build deployed");
    }
}