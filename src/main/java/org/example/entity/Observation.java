package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Observation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Specie specie;

    private String observerName;
    private String location;
    private double latitude;
    private double longitude;
    private LocalDate observationDate;
    private String comment;

    @OneToOne(mappedBy = "observation", cascade = CascadeType.ALL)
    private Deplacement deplacements;
}
