package Login;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Login {
    static LoginCommand command = new LoginCommand();
    static Scanner myObj = new Scanner(System.in);
    static int line = 0;
    static public void go(){
        System.out.println("Welcome " + command.getLoginUsername() +"\n" + command.getLoginUsername() +
            "'s login times: " + command.getAccountSystem().logIn(command.getLoginUsername(),
            command.getLoginPassword()).loginHistory(LocalDateTime.now()));
        GameProgram.Menu main = new GameProgram.Menu();
        main.mainMenu(command.getAccountSystem().logIn(command.getLoginUsername(),
                command.getLoginPassword()));
    }
    public static void main(String[] args) {
        System.out.println("-----Welcome-----");
        while (command.isRunning()) {
            if (line == 0) {
                System.out.println("Type OLD to LOGIN or NEW to CREATE an account");
            }
            else if (line == 1) {
                System.out.println("Enter username of length between 5 and 8 inclusive. No special symbols.");
            }
            else if ((line == 2)) {
                System.out.println("Enter password of length between 8 and 12 inclusive. No special symbols.");
            }
            else if (line == 3) {
                System.out.println("ADMIN or NO");
            }
            else if (line == 4) {
                System.out.println("Enter username");
            }
            else if (line == 5) {
                System.out.println("Enter password");
            }
            else if (line == 6) {
                go();
            }
            else if (line == 8) {
                System.out.println("Invalid Username or Password");
            }
            if ((line != 8) & (line != 6)) {
                String userInput = myObj.nextLine();
                line = command.inputCheck(userInput);
            } else {line = 0;}
        }
        System.out.println("Exited");
    }
}