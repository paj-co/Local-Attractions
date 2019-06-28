package pl.coderslab.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    boolean active;
    private LocalDateTime starts;
    private LocalDateTime ends;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;


}
