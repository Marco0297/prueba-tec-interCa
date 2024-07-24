package com.group.intercam.utils;

import com.group.intercam.constants.Constants;
import com.group.intercam.model.UsuarioModel;
import org.springframework.http.ResponseEntity;

public class IntercamUtils {

    /**
     * Valida que los ingresos sean mayores a 0
     * @param usuario
     * @return
     */
    public ResponseEntity ingresosValidate(UsuarioModel usuario){
        if (usuario.getCuenta().getIngresos() <=0) {

            return ResponseEntity.badRequest().body(Constants.BAD_REQUEST_MIN_ONE);
        }
        return null;//Si la validacion es correcta, retorna null
    }

    /**
     * Valida que el numero de cuenta contenga 10 caracteres
     * @param usuario
     * @return
     */
    public ResponseEntity numCuentaValidate(UsuarioModel usuario){
        if (String.valueOf(usuario.getCuenta().getNumeroCuenta()).length() != 10){
            return ResponseEntity.badRequest().body(Constants.BAD_REQUEST_EXACT_TEN);
        }
        return null;//Si la validacion es correcta, retorna null
    }

    /**
     * Valida que el CP sea de 6 caracteres
     * @param usuario
     * @return
     */
    public ResponseEntity cpValidate(UsuarioModel usuario){
        if (usuario.getDireccion().getCodigoPostal().length() != 6){
            return ResponseEntity.badRequest().body(Constants.BAD_REQUEST_CP);
        }
        return null;//Si la validacion es correcta, retorna null
    }
}
