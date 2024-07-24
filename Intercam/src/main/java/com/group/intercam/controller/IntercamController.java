package com.group.intercam.controller;

import com.group.intercam.model.UsuarioModel;
import com.group.intercam.service.IIntercamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud-intercam")
public class IntercamController {

    @Autowired
    private IIntercamService service;

    /**
     * Endpoint para agregar un nuevo usuario
     * @param userModel
     * @return
     */
    @PostMapping("/addUser")
    public ResponseEntity saveUser(@RequestBody UsuarioModel userModel){
        return service.addUser(userModel);
    }

    /**
     * Endpoint para mostrar todos los usuarios
     * @return
     */
    @GetMapping("/getUser")
    public ResponseEntity<List<UsuarioModel>> getUsers(){
        return service.getAllUsers();
    }

    /**
     * Endpoint para traer usuario por id
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<UsuarioModel> findById(@PathVariable Integer id){
        return service.findUserById(id);
    }

    /**
     * Endpoint pra actualizar Usuario
     * @param modelUpdate
     * @param id
     * @return
     */
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<List<UsuarioModel>>updateUser(@RequestBody UsuarioModel modelUpdate ,@PathVariable Integer id){
        ResponseEntity<List<UsuarioModel>> response = service.updateUser(modelUpdate, id);
        return response;
    }

    /**
     * Elimina por ID
     * @param id
     */
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteUserById(id);
    }
    /**
     * Elimina todos
     *
     */
    @DeleteMapping("/delete")
    public void delete(){
        service.deleAllUsers();
    }
}
