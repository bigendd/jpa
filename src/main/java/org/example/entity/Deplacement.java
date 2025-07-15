package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.TravelMode;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Deplacement {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "observation_id")
    private Observation observation;

    private double distanceKm;
    private TravelMode mode;
}
