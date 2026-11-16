package Reflection_Serialization;

import java.io.Serializable;

// Marker interface Serializable signals to the JVM that this object can be converted to bytes
public class UserSession implements Serializable {

    // Recommended version identifier to ensure class compatibility during deserialization
    private static final long serialVersionUID = 1L;

    private String username;
    private String role;

    // 'transient' prevents sensitive data from being written to disk!
    private transient String sessionPassword;

    public UserSession(String username, String role, String sessionPassword) {
        this.username = username;
        this.role = role;
        this.sessionPassword = sessionPassword;
    }

    @Override
    public String toString() {
        return "UserSession [username=" + username +
                ", role=" + role +
                ", sessionPassword=" + sessionPassword + "]";
    }
}