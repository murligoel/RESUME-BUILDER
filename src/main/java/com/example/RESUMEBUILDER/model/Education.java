package com.example.RESUMEBUILDER.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "education")
@Data
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String highSchoolName;

    @NotEmpty
    private String intermediateSchoolName;

    @NotEmpty
    private String graduationCollegeName;

    @NotEmpty
    private String highSchoolPercentage;

    @NotEmpty
    private String intermediatePercentage;

    @NotEmpty
    private String graduationPercentage;

    @NotEmpty
    private String highSchoolPassingYear;

    @NotEmpty
    private String intermediatePassingYear;

    @NotEmpty
    private String graduatingYear;

}
