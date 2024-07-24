package com.group.intercam.service;

import com.group.intercam.model.UsuarioModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IIntercamService {

    /**
     * Guarda un usuario con sus caracteristicas
     * @param usuario
     * @return
     */
    ResponseEntity<?> addUser(UsuarioModel usuario);

    /**
     * Obtener todos los usuarios
     * @return
     */
    ResponseEntity<List<UsuarioModel>>getAllUsers();

    /**
     * Busca usuarios por ID
     * @return
     */
    ResponseEntity<UsuarioModel>findUserById(Integer id);

    /**
     * Actualizar usuario por id
     * @param usuario
     * @param id
     * @return
     */
    ResponseEntity<List<UsuarioModel>>updateUser(UsuarioModel usuario, Integer id);

    /**
     * Elimina usuario por id
     * No retorna valor
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * Elimina todos los usuarios
     */
    void deleAllUsers();
}
