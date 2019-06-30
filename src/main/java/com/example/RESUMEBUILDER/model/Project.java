package com.example.RESUMEBUILDER.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> projectName;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> projectLink;
}
