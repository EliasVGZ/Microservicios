package usuario_service.usuario_service.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import usuario_service.usuario_service.modelos.Carro;
import usuario_service.usuario_service.modelos.Motos;

import java.util.List;

@FeignClient(name = "carro-service",url = "http://localhost:8082")

//@RequestMapping("/carro")
public interface CarroFeignClient {


    @PostMapping("/carro")
    public Carro save(@RequestBody Carro carro);


    @GetMapping("/carro/usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);






}
