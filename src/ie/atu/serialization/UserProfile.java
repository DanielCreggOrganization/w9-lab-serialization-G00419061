package ie.atu.serialization;

import java.io.Serializable;

public class UserProfile implements Serializable{
    private String username;
    private transient String password;
    private transient int loginAttempts;
    private String email;
    
    public UserProfile(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loginAttempts = 0;
    }
    
    @Override
    public String toString() {
        return String.format("UserProfile{username='%s', password='%s', " +
                           "loginAttempts=%d, email='%s'}", 
                           username, password, loginAttempts, email);
    }

}
