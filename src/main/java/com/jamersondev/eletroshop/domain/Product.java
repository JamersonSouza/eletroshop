package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
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

    private String typeUnit;

    private String name;

    @Column(columnDefinition = "text",length = 2000)
    private String description;

    private Double weight;

    private Double height;

    private Double width;

    private Double depth;

    private BigDecimal saleValue = BigDecimal.ZERO;

    private Integer stockQuantity;

    private Integer alertStockQuantity;

    private boolean alertQuantityStock = Boolean.FALSE;

    private Integer linkVideoYoutube;

    private Integer clicksQuantity;

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
