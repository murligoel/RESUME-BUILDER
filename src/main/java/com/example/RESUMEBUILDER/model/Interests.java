package com.example.RESUMEBUILDER.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "interest")
public class Interests {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> mentionInterests;
}
