package com.example.riotshop_api.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name_account"})
})
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccount;
    @Column(name = "name_account", columnDefinition = "varchar(255)")
    private String nameAccount;
    @Column(name = "password_account", columnDefinition = "varchar(255)")
    private String passwordAccount;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_account"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    Set<Role> role = new HashSet<>();

    public AccountUser() {
    }

    public AccountUser(int idAccount, String nameAccount, String passwordAccount, Set<Role> role) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.passwordAccount = passwordAccount;
        this.role = role;
    }

    public AccountUser(String username, String encode) {
        this.nameAccount = username;
        this.passwordAccount = encode;
    }



    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }


    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + idAccount +
                ", nameAccount='" + nameAccount + '\'' +
                ", passwordAccount='" + passwordAccount + '\'' +
                ", roles=" + role +
                '}';
    }
}
