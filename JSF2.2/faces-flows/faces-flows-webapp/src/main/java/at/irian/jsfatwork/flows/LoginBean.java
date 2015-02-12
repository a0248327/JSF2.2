package at.irian.jsfatwork.flows;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped("login")
public class LoginBean implements Serializable {
    private String username;
    private String password;

    public String login() {
        if ("user".equals(username) && "pwd".equals(password)) {
            return "success";
        } else {
            return "error";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
