package Design_Patterns;

public class UserProfile {

    // All fields are 'final' -> Object is completely IMMUTABLE once built
    private final String username;     // Required
    private final String email;        // Required
    private final String phone;        // Optional
    private final String city;         // Optional
    private final boolean isVerified;  // Optional

    // Private constructor accepts ONLY the Builder object
    private UserProfile(UserBuilder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.city = builder.city;
        this.isVerified = builder.isVerified;
    }

    @Override
    public String toString() {
        return "UserProfile [username=" + username + ", email=" + email +
                ", phone=" + phone + ", city=" + city + ", verified=" + isVerified + "]";
    }

    // Static Nested Builder Class
    public static class UserBuilder {
        // Required parameters
        private final String username;
        private final String email;

        // Optional parameters initialized to sensible defaults
        private String phone = "N/A";
        private String city = "Not Specified";
        private boolean isVerified = false;

        // Builder constructor enforces required fields
        public UserBuilder(String username, String email) {
            this.username = username;
            this.email = email;
        }

        // Fluent setter methods return 'this' (the Builder itself) for chaining
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder verified(boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        // Terminal build() method creates and returns the final immutable UserProfile
        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}