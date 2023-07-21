package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "physical_person")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")//aponta para o ID da abstração
public class PersonPF extends Person{

    private static final long serialVersionUID = -31354012788769691L;


    @Column(name = "cpf_person", nullable = false)
    private String cpf;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(mappedBy = "personPf", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<Address>();



}
