package usuario_service.usuario_service.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usuario_service.usuario_service.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Buscar usuario por nombre
    Usuario findByNombre(String nombre);
}
