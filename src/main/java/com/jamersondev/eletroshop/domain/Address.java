package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address implements Serializable {

    private static final long serialVersionUID = -6585019090621275453L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "street")
    private String street;

    @Column(name = "number_house")
    private String number;

    @Column(name = "complement_address")
    private String complement;

    @Column(name = "district")
    private String district;

    @Column(name = "UF")
    private String uf;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "personPf_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPf_fk"))
    private PersonPF personPf;

    @ManyToOne
    @JoinColumn(name = "personPj_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPj_fk"))
    private PersonPF personPj;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
