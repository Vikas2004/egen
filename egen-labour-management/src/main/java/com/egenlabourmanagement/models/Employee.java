package com.egenlabourmanagement.models;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "e_generator")
    @SequenceGenerator(
            name = "employee_generator",
            sequenceName = "employee_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail_id")
    private String mailId;

    @Column(name = "phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail_id() {
        return mailId;
    }

    public void setMail_id(String mailId) {
        this.mailId = mailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
