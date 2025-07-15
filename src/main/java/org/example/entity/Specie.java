package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Specie {


    @Id
    @GeneratedValue
    private long id;
    private String commonName;
    private String scientificName;
    private Category category;

    @ManyToMany(mappedBy = "specieList")
    private List<Region> regions;


}
