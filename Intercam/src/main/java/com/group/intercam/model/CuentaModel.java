package com.group.intercam.model;

import com.group.intercam.constants.Constants;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= Constants.TABLA_CUENTAS)
public class CuentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.TABLA_CUENTAS_ID)
    private Integer id;

    @Column(name = Constants.TABLA_CUENTAS_NUMERO_CUENTA)
    private int numeroCuenta;

    @Column(name = Constants.TABLA_CUENTAS_INGRESOS)
    private float ingresos;
}
