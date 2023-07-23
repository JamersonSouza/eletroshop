package com.jamersondev.eletroshop.domain;

import com.jamersondev.eletroshop.enums.TypeAddress;
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

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number_house", nullable = false)
    private String number;

    @Column(name = "complement_address")
    private String complement;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "UF", nullable = false)
    private String uf;

    @Column(name = "city", nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "personPf_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPf_fk"))
    private PersonPF personPf;

    @ManyToOne
    @JoinColumn(name = "personPj_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPj_fk"))
    private PersonPF personPj;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeAddress typeAddress;


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
