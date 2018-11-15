public class User {
    private String username;
    private String password;
    private boolean flag;
    //private String role;

    public User(String uname, String pw){
        this.username = uname;
        this.password = pw;
        //this.role = role;
    }
    public User(String uname, String pw, boolean flag){
        this.username = uname;
        this.password = pw;
        this.flag = flag;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
