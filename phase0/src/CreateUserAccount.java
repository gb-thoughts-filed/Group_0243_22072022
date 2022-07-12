import java.util.ArrayList;
import java.util.List;
public class CreateUserAccount extends ValidateCredentials{
    private String newUsername;
    private String newPassword;

    protected boolean admin;

    protected static List<UserAccount> allCreatedUsers  = new ArrayList<>();


    public CreateUserAccount(String newUsername, String newPassword, boolean admin) {
        this.newUsername = newUsername;
        this.newPassword = newPassword;
        this.admin = admin;
    }

    public boolean uniqueUsername(String username){
        for (UserAccount user: allCreatedUsers){
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean createUsername(String username) {
        if (isValidUsername(username)) {
            this.newUsername = username;
            return true;
        }
        else return false;
    }

    public boolean createPassword(String password) {
        if (isValidPassword(password)) {
            this.newPassword = password;
            return true;
        }
        else return false;
    }

    public String getNewPassword() { return this.newPassword; }

    public UserAccount createUserAccount() {
        if (createPassword(this.newPassword) && createUsername(this.newUsername)) {
            if (this.admin) {
                AdminAccount admin = new AdminAccount(this.newUsername, this.newPassword);
                allCreatedUsers.add(admin);
                return admin;
            } else {
                UserAccount user = new UserAccount(this.newUsername, this.newPassword, false);
                allCreatedUsers.add(user);
                return user;
            }
        }
        else return null;
    }
}