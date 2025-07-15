package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Climat;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Region {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double surface;
    private Climat climat;

    @ManyToMany
    @JoinTable(name = "specie_region", joinColumns = @JoinColumn(name = "specie_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id"))

    private List<Specie> specieList;

}
