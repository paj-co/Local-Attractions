package pl.coderslab.entity;

import javax.persistence.*;

@Entity
@Table(name = "localities")
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune;

}
