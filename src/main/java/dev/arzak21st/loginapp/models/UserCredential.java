package dev.arzak21st.loginapp.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_credential")
public class UserCredential implements Serializable {

    /* ========== PROPRTIES ========== */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /* ========== CONSTRUCTORS ========== */
    public UserCredential() {
        
    }

    public UserCredential(Integer userId, String username, String email, String password) {

        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /* ========== GETTERS & SETTERS ========== */
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /* ========== OTHER METHODS ========== */
    @Override
    public boolean equals(Object obj) {

        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }

        final UserCredential other = (UserCredential) obj;

        if(!Objects.equals(this.username, other.username)) {
            return false;
        }
        if(!Objects.equals(this.email, other.email)) {
            return false;
        }
        if(!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.userId, other.userId);
    }
}
