package usuario_service.usuario_service.Servicio;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import usuario_service.usuario_service.entidades.Usuario;
import usuario_service.usuario_service.feignclients.CarroFeignClient;
import usuario_service.usuario_service.feignclients.MotoFeignClient;
import usuario_service.usuario_service.modelos.Carro;
import usuario_service.usuario_service.modelos.Motos;
import usuario_service.usuario_service.repositorio.UsuarioRepository;

import java.util.*;

@Service
public class UsuarioServicio {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarroFeignClient carroFeignClient;
    @Autowired
    private MotoFeignClient motoFeignClient;


    @Autowired
    private UsuarioRepository usuarioRepository;


    //TODO CONEXION DE MICROSERVICIOS USANDO REST TEMPLATE
    //Creacion de un metodo para poder conectar con el servicio de carros
    public List<Carro> getCarros(int usuarioId){
        String urlCarro = "http://localhost:8082/carro/usuario/"+usuarioId;
        return restTemplate.getForObject(urlCarro, List.class);
    }

    //Creacion de un metodo para poder coenctar con el servici de motos
    public List<Motos> getMotos(int usuarioId){
        String urlCarro = "http://localhost:8083/moto/usuario/"+usuarioId;
        return restTemplate.getForObject(urlCarro, List.class);
    }




    //TODO CONEXION DE MICROSERVICIOS USANDO FEIGNCLIENT
    //Creacion de un metodo para guardar un carro, usando fiegnclient
    public Carro saveCarro(int usuarioId, Carro carro){
        carro.setUsuarioId(usuarioId);//se le asigna el usuarioId al carro
        return carroFeignClient.saveCoche(carro);
    }

    //Creacion de un metodo para guardar una moto, usando fiegnclient
    public Motos saveMoto(int usuarioId, Motos moto){
        moto.setUsuarioId(usuarioId);//se le asigna el usuarioId a la moto
        return motoFeignClient.save(moto);
    }


    public Map<String, Object> getUsuarioAndVehiculos(int usuarioId) {

        Map<String, Object> resultado = new LinkedHashMap<>(); // Usar LinkedHashMap para mantener el orden
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null); // Buscar el usuario por id

        if (usuario == null) {
            resultado.put("mensaje", "Usuario no encontrado");
            return resultado;
        }

        resultado.put("usuario", usuario);

        try {
            List<Carro> carros = carroFeignClient.getCarros(usuarioId);
            if (carros.isEmpty()) {
                resultado.put("carros", new ArrayList<>()); // Agregar una lista vacía si no hay carros
            } else {
                resultado.put("carros", carros);
            }
        } catch (FeignException e) {
            if (e.status() == 404) {
                resultado.put("carros", new ArrayList<>()); // Manejar 404 como lista vacía
            } else {
                resultado.put("mensaje", "Error al obtener carros: " + e.getMessage());
            }
        }

        try {
            List<Motos> motos = motoFeignClient.getMotos(usuarioId);
            if (motos.isEmpty()) {
                resultado.put("motos", new ArrayList<>()); // Agregar una lista vacía si no hay motos
            } else {
                resultado.put("motos", motos);
            }
        } catch (FeignException e) {
            if (e.status() == 404) {
                resultado.put("motos", new ArrayList<>()); // Manejar 404 como lista vacía
            } else {
                resultado.put("mensaje", "Error al obtener motos: " + e.getMessage());
            }
        }

        return resultado;
    }


















    //Crear usuario
    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //ver todos los usuarios
    public List<Usuario> allUsuarios(){
        return usuarioRepository.findAll();
    }

    //ver usuario por id
    public Usuario getUsuarioPorId(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    //buscar usuario por nombre
    public Usuario getUsuarioPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }


}
