package Main;

import java.io.Serializable;

public abstract class PasswordSystem implements Serializable {
    private static final long serialVersionUID = 1L;

    abstract String getPass();
    abstract void setPass(String newPass);
}