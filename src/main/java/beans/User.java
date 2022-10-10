package beans;

public class User {

    private int user_id;
    private String user_password;
    private String user_name;
    private String last_name;
    private String email;
    private String location_user;

    public User(int user_id, String user_password, String user_name, String last_name, String email, String location_user) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
        this.last_name = last_name;
        this.email = email;
        this.location_user = location_user;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation_user() {
        return location_user;
    }

    public void setLocation_user(String location_user) {
        this.location_user = location_user;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name + ", last_name=" + last_name + ", email=" + email + ", location_user=" + location_user + '}';
    }

}
