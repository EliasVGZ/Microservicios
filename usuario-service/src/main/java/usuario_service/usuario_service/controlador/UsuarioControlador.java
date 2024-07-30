package usuario_service.usuario_service.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usuario_service.usuario_service.Servicio.UsuarioServicio;
import usuario_service.usuario_service.entidades.Usuario;
import usuario_service.usuario_service.modelos.Carro;
import usuario_service.usuario_service.modelos.Motos;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {


    @Autowired
    private UsuarioServicio usuarioServicio;

    //Mapear todos los usuaroios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioServicio.allUsuarios();
        if(usuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(usuarios);
    }

    //Guardar usuario
    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){

        Usuario nuevoUsuario = usuarioServicio.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    //Buscar usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable ("id") int id){
        Usuario usuario = usuarioServicio.getUsuarioPorId(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(usuario);
    }

    //TODO CONEXION DE MICROSERVICIOS USANDO REST TEMPLATE

    //Obtener carros de un usuario
    @GetMapping("carros/{usuarioId}")

    public ResponseEntity<List<Carro>> listarCarros(@PathVariable ("usuarioId") int id){
        Usuario usuario = usuarioServicio.getUsuarioPorId(id);
        if(usuario == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Carro> carros = usuarioServicio.getCarros(id);
        return ResponseEntity.ok(carros);
    }

    //Obtener motos de un usuario
    @GetMapping("motos/{usuarioId}")

    public ResponseEntity<List<Motos>> listarMotos(@PathVariable ("usuarioId") int id){
        Usuario usuario = usuarioServicio.getUsuarioPorId(id);
        if(usuario == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Motos> motos = usuarioServicio.getMotos(id);
        return ResponseEntity.ok(motos);
    }



    //TODO CONEXION DE MICROSERVICIOS USANDO FEIGNCLIENT
    //Crear un carro usando feignclient
    @PostMapping("carro/{usuarioId}")
    public ResponseEntity<Carro> guardarCarro(@PathVariable ("usuarioId") int usuarioId, @RequestBody Carro carro){
        Carro nuevoCarro = usuarioServicio.saveCarro(usuarioId, carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    //Crear una moto usando feignclient
    @PostMapping("moto/{usuarioId}")
    public ResponseEntity<Motos> guardarMoto(@PathVariable ("usuarioId") int usuarioId, @RequestBody Motos moto){
        Motos nuevaMoto = usuarioServicio.saveMoto(usuarioId, moto);
        return ResponseEntity.ok(nuevaMoto);
    }

    @GetMapping("todos/{usuarioId}")
    public ResponseEntity<Map<String, Object>> obtenerUsuarioAndVehiculos(@PathVariable ("usuarioId") int usuarioId){
        return ResponseEntity.ok(usuarioServicio.getUsuarioAndVehiculos(usuarioId));
    }







    //Buscar usuario por nombre
    /*
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Usuario> obtenerUsuarioPorNombre(@PathVariable ("nombre") String nombre){
        Usuario usuario = usuarioServicio.getUsuarioPorNombre(nombre);
        if(usuario == null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(usuario);
    }*/


}
