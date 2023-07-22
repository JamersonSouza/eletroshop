package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sell_and_buy_store_virtual")
@Getter
@Setter
public class SellAndBuyStore implements Serializable {

    private static final long serialVersionUID = 6722055912421672440L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personPf_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPf_buy_store_virtual_fk"))
    private PersonPF personPf;

    @ManyToOne
    @JoinColumn(name = "address_billing_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "address_billing_fk"))
    private Address billingAddress;

    @ManyToOne
    @JoinColumn(name = "address_delivery_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "address_delivery_fk"))
    private Address deliveryAddress;

    private BigDecimal amount;

    private BigDecimal valueDiscount;

    @ManyToOne
    @JoinColumn(name = "formOfPayment_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "formOfPayment_buy_store_virtual_fk"))
    private FormOfPayment formOfPayment;

    @OneToOne
    @JoinColumn(name = "invoice_sale_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "invoice_sale_fk"))
    private InvoiceSale invoiceSale;

    @ManyToOne
    @JoinColumn(name = "couponDiscount_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "couponDiscount_buy_store_virtual_fk"))
    private CouponDiscount couponDiscount;

    private BigDecimal valueFreight;

    private Integer daysToDelivery;

    @Temporal(TemporalType.DATE)
    private Date dayOfSale;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellAndBuyStore that = (SellAndBuyStore) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
