package com.example.zeDelivery.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = Partner.TABLE_NAME)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Partner {
    public static final String TABLE_NAME = "partner";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotBlank
    @Column(name = "tradingName")
    private String tradingName;

    @NotBlank
    @Column(name = "ownerName")
    private String ownerName;

    @NotBlank
    @Column(name = "document", unique = true)
    private String document;

    @NotBlank
    @Column(name = "coverageAreaCoordinates")
    private List<List<List<Double>>> coverageAreaCoordinates;

    @NotBlank
    @Column(name = "addressCoordinates")
    private List<Double> addressCoordinates;

}
