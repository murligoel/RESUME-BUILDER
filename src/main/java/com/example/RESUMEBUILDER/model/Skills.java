package com.example.RESUMEBUILDER.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> skill;
}
