import java.util.ArrayList;
import java.util.List;
public class Userdb {
    private List<User> userdbms = new ArrayList<User>();

    Userdb(){
        userdbms.add(new User("User1","123"));
        userdbms.add(new User("User2","234"));
    }

    public List<User> getUserdbms() {
        return userdbms;
    }
}
