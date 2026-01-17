package Main;

public class AdminLogin extends PasswordSystem {
    private static final long serialVersionUID = 2L;

    String userName1 = "Shohan Helal";
    String userName2 = "Nasiruddin Sha Rafi";
    private String password = "123";

    @Override
    String getPass() {
        return password;
    }

    @Override
    void setPass(String newPass) {
        if (newPass != null && !newPass.trim().isEmpty()) {
            this.password = newPass;
        }
    }

    void display() {
        System.out.println("Admin Names : " + userName1 + " & " + userName2);
    }
}