package com.example.dagent.Entities;

import com.example.dagent.Enum.ProjectStatus;
import com.example.dagent.Enum.PropertyType;
import com.example.dagent.Enum.Tenure;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "name cannot null")
    private String projectName;
    private Integer minNoOfRoomsPerUnit;
    private Integer maxNoOfRoomsPerUnit;
    private Integer smallestSquareFeet;
    private Integer largestSquareFeet;
    private Integer lowestPricePerSquareFeet;
    private Integer highestPricePerSquareFeet;
    private String address;
    private String developerName;
    private Integer yearOfCompletion;
    private Integer totalNoOfUnits;
    private String siteArea;
    private Integer managementFee;
    private Integer noOfLifts;
    private Integer totalLandAces;
    private String projectDescription;
    @ElementCollection
    private List<String> facilities;
    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private Tenure tenure;

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Getter
    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private ProjectStatus projectStatus;

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    @Getter
    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private PropertyType propertyType;

}
