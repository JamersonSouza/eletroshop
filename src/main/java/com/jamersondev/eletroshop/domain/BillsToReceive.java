package com.jamersondev.eletroshop.domain;

import com.jamersondev.eletroshop.enums.BillsToReceiveStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bills_to_receive")
@Getter
@Setter
public class BillsToReceive implements Serializable {

    private static final long serialVersionUID = -6585019090621275453L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private BillsToReceiveStatus billsToReceiveStatus;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private BigDecimal amount;

    private BigDecimal discountValue;

    @ManyToOne
    @JoinColumn(name = "personPf_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPf_fk"))
    private PersonPF personPf;

    @ManyToOne
    @JoinColumn(name = "personPj_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "personPj_fk"))
    private PersonPF personPj;


}
