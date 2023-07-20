package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
    @Column(name = "email",columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "phone_number",columnDefinition = "varchar(255)")
    private String phoneNumber;
    @Column(name = "image",columnDefinition = "varchar(255)")
    private String image;


    public AccountUser(Integer accountUserId) {
        this.idAccount = accountUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_account"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    Set<Role> role = new HashSet<>();
    @JsonBackReference
    @OneToMany(mappedBy = "accountUser")
    @OrderBy("idOrder desc")
    private Set<OrderCustomer> orderCustomerSet=new TreeSet<>();

    public AccountUser() {
    }

    public AccountUser(int idAccount, String nameAccount, String passwordAccount, String email, String phoneNumber, Set<Role> role, Set<OrderCustomer> orderCustomerSet) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.passwordAccount = passwordAccount;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.orderCustomerSet = orderCustomerSet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AccountUser(int idAccount, String nameAccount, String passwordAccount, String email, String phoneNumber, String image, Set<Role> role, Set<OrderCustomer> orderCustomerSet) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.passwordAccount = passwordAccount;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.role = role;
        this.orderCustomerSet = orderCustomerSet;
    }

    public AccountUser(int idAccount, String nameAccount, String passwordAccount, Set<Role> role) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.passwordAccount = passwordAccount;
        this.role = role;
    }

    public AccountUser(int idAccount, String nameAccount, String passwordAccount, String email, String phoneNumber, Set<Role> role) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.passwordAccount = passwordAccount;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public AccountUser(String username, String encode) {
        this.nameAccount = username;
        this.passwordAccount = encode;
    }

    public AccountUser( String nameAccount, String passwordAccount, String email, String phoneNumber) {
        this.nameAccount = nameAccount;
        this.passwordAccount = passwordAccount;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public Set<OrderCustomer> getOrderCustomerSet() {
        return orderCustomerSet;
    }

    public void setOrderCustomerSet(Set<OrderCustomer> orderCustomerSet) {
        this.orderCustomerSet = orderCustomerSet;
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
