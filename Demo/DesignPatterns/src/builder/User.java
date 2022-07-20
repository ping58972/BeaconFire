package builder;

public class User {
    private String username;
    private String password;

    private User(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }
    static class UserBuilder {
        private String username;
        private String password;

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new User.UserBuilder().setUsername("alex").setPassword("123").build();
    }
}
