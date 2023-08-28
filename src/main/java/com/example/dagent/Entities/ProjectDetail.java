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
    private String name;
    private String address;
    private String developer;

    private Integer yearOfCompletion;
    private Integer totalNoOfUnits;
    private String siteArea;
    @Enumerated(EnumType.STRING) // Specify the mapping strategy
    private Tenure tenure;
    private Integer managementFee;
    private Integer noOfLifts;
    private Integer totalLandAces;
    private String projectDescription;
    @Lob
    private byte[] image;

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
