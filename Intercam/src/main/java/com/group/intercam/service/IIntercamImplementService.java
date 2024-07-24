package com.group.intercam.service;

import com.group.intercam.constants.Constants;
import com.group.intercam.model.UsuarioModel;
import com.group.intercam.repository.IIntecamRepository;
import com.group.intercam.utils.IntercamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IIntercamImplementService implements IIntercamService{

    @Autowired
    private IIntecamRepository repository;

    /**
     * Guarda un usuario con sus caracteristicas
     *
     * @param usuario
     * @return
     */
    @Override
    public ResponseEntity<?> addUser(UsuarioModel usuario) {

        try{
            IntercamUtils utils = new IntercamUtils();

            ResponseEntity<?> validaNumCuenta = utils.numCuentaValidate(usuario);
            ResponseEntity<?> validaIngresos = utils.ingresosValidate(usuario);
            ResponseEntity<?> validaCp = utils.cpValidate(usuario);

            if (validaIngresos != null){
                return validaIngresos;
            }
            if (validaNumCuenta != null){
                return validaNumCuenta;
            }
            if (validaCp != null){
                return validaCp;
            }
            UsuarioModel usuarioModel = repository.save(usuario);
            return new ResponseEntity<>(usuarioModel, HttpStatus.CREATED);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR_500);
        }

    }

    /**
     * Obtener todos los usuarios
     *
     * @return
     */
    @Override
    public ResponseEntity<List<UsuarioModel>> getAllUsers() {
        List<UsuarioModel>list = repository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Busca usuarios por ID
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<UsuarioModel> findUserById(Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Actualizar usuario por id
     *
     * @param usuario
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<List<UsuarioModel>> updateUser(UsuarioModel usuario, Integer id) {
        Optional<UsuarioModel> optional = repository.findById(id);
        List<UsuarioModel>list = new ArrayList<>();
        if (optional.isPresent()){
            optional.get().setNombre(usuario.getNombre());
            optional.get().setApellidoPaterno(usuario.getApellidoPaterno());
            optional.get().setApellidoMaterno(usuario.getApellidoMaterno());
            optional.get().setFechaNacimiento(usuario.getFechaNacimiento());
            optional.get().setCuenta(usuario.getCuenta());
            optional.get().setDireccion(usuario.getDireccion());

            UsuarioModel modelUpdate = repository.save(optional.get());
            if (modelUpdate != null){
                list.add(modelUpdate);
                return new ResponseEntity<>(list,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Elimina usuario por id
     * No retorna valor
     *
     * @param id
     */
    @Override
    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Elimina todos los usuarios
     */
    @Override
    public void deleAllUsers() {
        repository.deleteAll();
    }
}
