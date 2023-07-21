package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serial;

@Entity
@Table(name = "legal_person")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")//aponta para o ID da abstração
public class PersonPJ extends Person{

    private static final long serialVersionUID = 5806456877172263438L;

    @Column(name = "cnpj_person")
    private String cnpj;

    private String stateRegistration;

    private String municipalRegistration;

    private String fantasyName;

    private String corporateName;

    private String category;


}
