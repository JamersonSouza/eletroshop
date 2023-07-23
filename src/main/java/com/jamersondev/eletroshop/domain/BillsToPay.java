package com.jamersondev.eletroshop.domain;

import com.jamersondev.eletroshop.enums.BillsToPayStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bills_to_pay")
@Getter
@Setter
public class BillsToPay implements Serializable {

    private static final long serialVersionUID = -6716001154619876461L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillsToPayStatus billsToPayStatus;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date expirationDate;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(nullable = false)
    private BigDecimal amount;

    private BigDecimal discountValue;

    @ManyToOne
    @JoinColumn(name = "personPj_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPj_billsToPay_fk"))
    private PersonPJ personPj;

    @ManyToOne
    @JoinColumn(name = "personPj_supplier_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPj_supplier_fk"))
    private PersonPJ personSupplier;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillsToPay that = (BillsToPay) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
