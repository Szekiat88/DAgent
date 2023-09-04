package com.example.dagent.Entities;

import com.example.dagent.Enum.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long facilityId;
    private String LocationName;
    private String locationDescription;
    private Integer travelDuration;
    private Integer projectId;

    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private FacilityType facilityType;

    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private TravellingMode travellingMode;

}
