package dev.arzak21st.loginapp.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

    /* ========== PROPRTIES ========== */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "country")
    private String country;

    @OneToOne(mappedBy = "user")
    private UserCredential userCredential;

    /* ========== CONSTRUCTORS ========== */
    public User() {

    }

    public User(String firstName, String lastName, Date dateOfBirth, String gender, String country) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
    }

    public User(Integer userId, String firstName, String lastName, Date dateOfBirth, String gender, String country) {
        
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
    }

    /* ========== GETTERS & SETTERS ========== */
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
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

        final User other = (User) obj;

        if(!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if(!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if(!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if(!Objects.equals(this.country, other.country)) {
            return false;
        }
        if(!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return Objects.equals(this.dateOfBirth, other.dateOfBirth);
    }
}
