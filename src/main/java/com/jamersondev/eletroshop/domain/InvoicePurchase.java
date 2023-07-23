package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "invoice_purchase")
@Getter
@Setter
public class InvoicePurchase implements Serializable {

    private static final long serialVersionUID = -8841718418436920774L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String numberInvoice;

    @Column(nullable = false)
    private String seriesInvoice;

    private String description;

    private BigDecimal amountInvoice;

    private BigDecimal valueDiscountInvoice;

    @Column(nullable = false)
    private BigDecimal valueIcmsInvoice;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date buyDate;

    @ManyToOne
    @JoinColumn(name = "personPf_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPf_invoicePurchase_fk"))
    private PersonPF personPf;

    @ManyToOne
    @JoinColumn(name = "personPj_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPj_invoicePurchase_fk"))
    private PersonPF personPj;

    @ManyToOne
    @JoinColumn(name = "billsToPay_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "billsToPay_invoicePurchase_fk"))
    private BillsToPay billsToPay;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicePurchase that = (InvoicePurchase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
