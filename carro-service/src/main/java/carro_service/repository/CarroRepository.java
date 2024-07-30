package carro_service.repository;

import carro_service.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    //listar carros por usuario
    List<Carro> findByUsuarioId(int usuarioId);
}
