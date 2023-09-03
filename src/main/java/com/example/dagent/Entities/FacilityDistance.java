package com.example.dagent.Entities;

import com.example.dagent.Enum.*;
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
public class FacilityDistance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String LocationName;
    private String locationDescription;
    private Integer travelDuration;

    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private FacilityType facilityType;

    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private TravellingMode travellingMode;


}
