package com.moto_service.demo.repository;

import com.moto_service.demo.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {

    //listar motos por usuario
    List<Moto> findByUsuarioId(int usuarioId);
}
