package bean;

/**
 * @author LX
 * @date 2019/4/13 - 17:06
 */
public class User {
    public User() {
    }

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    private Integer uid;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return uid;
    }

    public void setId(Integer id) {
        this.uid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
