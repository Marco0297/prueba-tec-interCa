package com.group.intercam.repository;

import com.group.intercam.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntecamRepository extends JpaRepository<UsuarioModel, Integer> {
    /**
     * Creamos nuestra interface que interactua con JPA
     */
}
