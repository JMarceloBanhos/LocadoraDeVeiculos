package com.jmbb.locadora.locadora.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "VEICULO")
@Data
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "ANO")
    private int ano;
}
