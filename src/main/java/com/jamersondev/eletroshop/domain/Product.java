package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product implements Serializable {


    private static final long serialVersionUID = 1874736754400698840L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String typeUnit;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text",length = 2000,  nullable = false)
    private String description;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double depth;

    @Column(nullable = false)
    private BigDecimal saleValue = BigDecimal.ZERO;

    @Column(nullable = false)
    private Integer stockQuantity;

    private Integer alertStockQuantity;

    private boolean alertQuantityStock = Boolean.FALSE;

    private Integer linkVideoYoutube;

    private Integer clicksQuantity = 0;

    @Column(nullable = false)
    private Boolean active = Boolean.TRUE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
