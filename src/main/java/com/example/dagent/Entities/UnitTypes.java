package com.example.dagent.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String unitType;
    private Integer totalNoOfUnits;
    private Integer priceStartFrom;
    private Integer projectId;
    private Integer noOfBedroom;
    private Integer noOfBathRoom;
    private Integer noOfCarPark;
    private Boolean balcony;
    private Boolean yard;
    private Integer unitSquareFeet;


}
