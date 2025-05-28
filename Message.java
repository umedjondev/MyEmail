import java.time.LocalDate;

public class Message {
    private User fromUser;
    private User toUser;
    private String text;
    private LocalDate date;
    public Message(User fromUser,User toUser,String text){
        this.toUser=toUser;
        this.fromUser=fromUser;
        this.text=text;
        date=LocalDate.now();

    }
    public User getFromUser(){
        return fromUser;
    }
    public User getToUser(){
        return toUser;
    }
    public String getText(){
        return text;
    }
    public LocalDate getDate(){
        return date;
    }
}
