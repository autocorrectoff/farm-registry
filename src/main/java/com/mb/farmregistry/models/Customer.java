package com.mb.farmregistry.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Farm> farms;
}
