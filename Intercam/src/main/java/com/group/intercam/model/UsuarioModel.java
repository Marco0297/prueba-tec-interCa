package com.group.intercam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.group.intercam.constants.Constants;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name=Constants.TABLA_USUARIOS)
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.TABLA_USUARIO_ID)
    private Integer id;

    @Column(name = Constants.TABLA_USUARIO_NOMBRE)
    private String nombre;

    @Column(name = Constants.TABLA_USUARIO_APELLIDO_PAT)
    private String apellidoPaterno;

    @Column(name = Constants.TABLA_USUARIO_APELLIDO_MAT)
    private String apellidoMaterno;

    /**
     * Definimos el formato de la fecha con JsonFormat
     */
    @Column(name=Constants.TABLA_USUARIO_FECHA_NACIMIENTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    /**
     * @OnoToOne define las relaciones entre las direntes tablas
     * @JoinColumn se usara para unir tablas
     * CUENTA_ID y DIRECCION_ID son claves foraneas que hacen referencia a id
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.CUENTA_ID, referencedColumnName = Constants.REFERENCE_ID)
    private CuentaModel cuenta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.DIRECCION_ID, referencedColumnName = Constants.REFERENCE_ID)
    private DireccionModel direccion;

}
