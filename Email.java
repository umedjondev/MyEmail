import java.util.ArrayList;
import java.util.List;

public class Email {
    String name;
    List<User> userList;
    List<Message> messageList;
    User currentUser;
    public Email(String name){
        this.name=name;
        userList=new ArrayList<>();
        userList.addAll(List.of(
                new User("Lola","lola@"+this.name,"1234"),
                new User("Madina","madina@"+this.name,"1234"),
                new User("Asil","asil@"+this.name,"1234")
                ));
        messageList=new ArrayList<>();
    }
    public void addUser(String name,String login,String password){
        boolean status=false;
        login=login+"@"+this.name;
        for (User user : userList) {
            if (login.equals(user.getLogin())){
                status=true;
                break;
            }
        }
        if (status){
            System.out.println("Bunday loginli user mavjud!");
        }else{
            User user = new User(name, login, password);
            userList.add(user);
        }
    }
    public Message sendMessage(User toUser,String text){
        Message message = new Message(this.currentUser, toUser, text);
        currentUser.addOutbox(message);
        toUser.addInbox(message);
        messageList.add(message);
        return message;
    }
    public void readMyMessage(){
        System.out.println("Kiruvchi xabarlar!");
        for (Message inbox : currentUser.getInbox()) {
            System.out.println("name: "+inbox.getFromUser().getName());
            System.out.println("date: "+inbox.getDate());
            System.out.println("text: "+inbox.getText());
            System.out.println("----------------------");
        }
        System.out.println("Chiquvchi xabarlar!");
        for (Message outbox : currentUser.getOutbox()) {
            System.out.println("name: "+outbox.getToUser().getName());
            System.out.println("date: "+outbox.getDate());
            System.out.println("text: "+outbox.getText());
            System.out.println("----------------------");
        }

    }
    public User selectUser(String login){
        if(!login.contains("@"))
            login=login+"@"+this.name;
        for (User user : userList) {
            if(login.equals(user.getLogin())){
                return user;
            }
        }
        return null;
    }
    public void showUsers(){
        for (User user : userList) {
            System.out.println("name: "+user.getName()+" login: "+user.getLogin());
        }
    }
    public boolean login(String login,String password){
        User user = selectUser(login);
        if (user!=null){
           if (user.getPassword().equals(password)){
               this.currentUser=user;
               return true;
           }else{
               System.out.println("Parol xato!");
               return false;
           }
        }else{
            System.out.println("Bunday user topilmadi");
            return false;
        }

    }
}
