package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public abstract class Person implements Serializable {

    private static final long serialVersionUID = -7081192372609496880L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_person", nullable = false)
    private String name;

    @Column(name = "email_person", nullable = false)
    private String mail;

    @Column(name = "phone_person", nullable = false)
    private String phone;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
