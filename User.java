import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String login;
    private String password;
    private List<Message>inbox,outbox;
    public User(String name, String login, String password){
        this.name =name;
        this.login = login;
        this.password = password;
        inbox = new ArrayList<>();
        outbox = new ArrayList<>();
    }
    public void addInbox(Message msg){
        inbox.add(msg);
    }
    public void addOutbox(Message msg){
        outbox.add(msg);
    }
    public List<Message> getInbox(){
        return inbox;
    }
    public List<Message> getOutbox(){
        return outbox;
    }
    public String getName(){
        return name;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
}
