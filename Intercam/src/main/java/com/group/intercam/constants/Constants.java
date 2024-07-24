package com.group.intercam.constants;

public class Constants {
    /**
     * Nombre de la tabla Usuarios
     */
    public static final String TABLA_USUARIOS = "usuarios";

    /**
     * Nombre de la tabla Cuentas
     */
    public static final String TABLA_CUENTAS = "cuentas";

    /**
     * Nombre de la tabla Direccion
     */
    public static final String TABLA_DIRECCION = "direccion";

    /**
     * Nombres de las varaibles para entity Usuario
     */
    public static final String TABLA_USUARIO_ID = "id";
    public static final String TABLA_USUARIO_NOMBRE = "nombre";
    public static final String TABLA_USUARIO_APELLIDO_PAT = "apellido_paterno";
    public static final String TABLA_USUARIO_APELLIDO_MAT = "apellido_materno";
    public static final String TABLA_USUARIO_FECHA_NACIMIENTO = "fecha_nacimiento";

    /**
     * Nombre de las variables para entity Cuentas
     */
    public static final String TABLA_CUENTAS_ID = "id";
    public static final String TABLA_CUENTAS_NUMERO_CUENTA = "numero_cuenta";
    public static final String TABLA_CUENTAS_INGRESOS = "ingresos";

    /**
     * Nombre de las variables para entity Direcciones
     */
    public static final String TABLA_DIRECCION_ID = "id";
    public static final String TABLA_DIRECCION_CP = "codigo_postal";
    public static final String TABLA_DIRECCION_ESTADO = "estado";

    /**
     * Nombres para hacer el relacionado entre tablas
     */
    public static final String DIRECCION_ID = "direccion_id";
    public static final String CUENTA_ID = "cuenta_id";
    public static final String REFERENCE_ID = "id";

    /**
     * Mensajes para validaciones
     */
    public static final String ERROR_500 = "Hubo un error interno en servidor";
    public static final String BAD_REQUEST_MIN_ONE = "El ingreso debe ser mayor a 0";
    public static final String BAD_REQUEST_EXACT_TEN = "El numero de cuenta debe tener 10 digitos";
    public static final String BAD_REQUEST_CP = "El Codio Postal debe tener 6 caracteres";



}
