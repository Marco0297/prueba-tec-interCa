package com.group.intercam.model;


import com.group.intercam.constants.Constants;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= Constants.TABLA_DIRECCION)
public class DireccionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.TABLA_DIRECCION_ID)
    private Integer id;

    @Column(name=Constants.TABLA_DIRECCION_CP)
    private String codigoPostal;

    @Column(name=Constants.TABLA_DIRECCION_ESTADO)
    private String estado;
}
