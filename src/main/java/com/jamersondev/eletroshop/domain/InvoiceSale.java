package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "invoice_sale")
@Getter
@Setter
public class InvoiceSale implements Serializable {

    private static final long serialVersionUID = 7183612129689657091L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String numberInvoice;

    @Column(nullable = false)
    private String seriesInvoice;

    @Column(nullable = false)
    private String type;

    @Column(columnDefinition = "text", nullable = false)
    private String xml;

    @Column(columnDefinition = "text", nullable = false)
    private String pdf;

    @OneToOne
    @JoinColumn(name = "sellAndBuy_store_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "sellAndBuy_store_fk"))
    private SaleAndBuyStore saleAndBuyStore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSale that = (InvoiceSale) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
