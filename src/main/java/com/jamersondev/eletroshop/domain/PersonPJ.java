package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "legal_person")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")//aponta para o ID da abstração
public class PersonPJ extends Person{

    private static final long serialVersionUID = 5806456877172263438L;

    @Column(name = "cnpj_person", nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String stateRegistration;

    private String municipalRegistration;

    @Column(nullable = false)
    private String fantasyName;

    @Column(nullable = false)
    private String corporateName;

    private String category;

    @OneToMany(mappedBy = "personPj", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<Address>();


}
