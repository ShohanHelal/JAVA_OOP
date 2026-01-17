package Main;

public class UserLogin extends PasswordSystem {
    private static final long serialVersionUID = 3L;

    String userName;
    private String password;

    public UserLogin(String userName) {
        this.userName = userName;
    }

    @Override
    String getPass() {
        return password;
    }

    @Override
    void setPass(String newPass) {
        this.password = newPass;
    }

    void display() {
        System.out.println("UserName : " + userName);
    }
}