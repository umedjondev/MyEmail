import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Email myEmail=new Email("gmail.com");
        System.out.println("akkaunt mavjud bo'lsa(1) aks holda (0)");
        int a=scanner.nextInt();
        boolean status1=false;
        if(a==1){

            System.out.print("loginni kiriting: ");
            String login=scanner.next();
            System.out.print("parolni kiriting: ");
            String parol=scanner.next();
            status1=myEmail.login(login,parol);
        }
        else {
            System.out.println("Avtorizatsiya oynasi: ");
            System.out.print("fio ni kiriting: ");
            scanner.nextLine();
            String name=scanner.nextLine();
            System.out.print("loginni kiriting: ");
            String login=scanner.next();
            System.out.print("parolni kiriting: ");
            String parol=scanner.next();
            myEmail.addUser(name,login,parol);
            status1=myEmail.login(login,parol);
        }


        while (status1){
            System.out.println(myEmail.currentUser.getName());
            System.out.println("1. new profile");
            System.out.println("2. send message");
            System.out.println("3. read my message");
            System.out.println("4. select user");
            System.out.println("5. all user's list");
            System.out.println("6. exit profile");
            System.out.println("0. exit");
            System.out.print("kerakli menyuni tanlang: ");
            int choice= scanner.nextInt();

            switch (choice){
                case 0:
                    return;

                case 1:
                    break;
                case 2:
                    myEmail.showUsers();
                    System.out.print("xat yuboriladigan loginni kiriting: ");
                    String login=scanner.next();
                    System.out.println("xabar matni: ");
                    scanner.nextLine();
                    String text=scanner.nextLine();
                    User toUser=myEmail.selectUser(login);
                    if(!toUser.equals(null))
                        myEmail.sendMessage(toUser,text);
                    else System.out.println("bunday account topilmadi");

                    break;
                case 3:
                    myEmail.readMyMessage();
                    break;
                case 4:
                    myEmail.showUsers();
                    System.out.print("login: ");
                    login=scanner.next();
                    System.out.print("parol: ");
                    String parol=scanner.next();
                    myEmail.login(login,parol);
                    break;
            }
            

        }
    }
}
