package com.project.endterm.model;

import javax.persistence.*;

@Entity
@Table(name = "userinfo")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name" ,unique = true)
    private String name;

    @Column(name = "age" , unique = true)
    private String age;

    @Column(name = "email" ,unique = true)
    private String email;

    @Column(name = "address" ,unique = true)
    private String address;

    @Column(name = "phone" ,unique = true)
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
