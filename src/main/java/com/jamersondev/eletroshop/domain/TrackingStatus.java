package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tracking_status")
@Getter
@Setter
public class TrackingStatus implements Serializable {

    private static final long serialVersionUID = 3528754406544212331L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String distributionCenter;

    private String city;

    private String state;

    private String status;

    @ManyToOne
    @JoinColumn(name = "sellAndBuy_store_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "tracking_sellAndBuy_store_fk"))
    private SellAndBuyStore sellAndBuyStore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackingStatus that = (TrackingStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
