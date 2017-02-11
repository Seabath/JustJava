package main.java.com.sdezee.entities;

import javax.persistence.*;

@Entity
@Table(name = "USERS",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="LOGIN", length=20, nullable=true)
    private String login;
    @Column(name="PASSWORD", length=20, nullable=true)
    private String password;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
