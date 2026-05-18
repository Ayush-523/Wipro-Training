package com.company.entity;

import java.util.ArrayList;
import java.util.List;

import com.company.entity.base.Address;
import com.company.entity.base.Person;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@DiscriminatorValue("TEACHER")

public class Teacher extends Person {

    private String subject;

    public Teacher(String name,
                   Address address,
                   String subject) {

        super(name, address);

        this.subject = subject;
    }

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )

    private List<Email> emails = new ArrayList<>();

    public void addEmail(String email) {

        Email e = new Email(email, this);

        emails.add(e);
    }
}