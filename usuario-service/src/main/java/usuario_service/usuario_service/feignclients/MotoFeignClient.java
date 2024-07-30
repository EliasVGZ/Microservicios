package usuario_service.usuario_service.feignclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import usuario_service.usuario_service.modelos.Motos;

import java.util.List;

@FeignClient(name = "moto-service",url = "http://localhost:8083")
public interface MotoFeignClient {


    @PostMapping("/moto")
    public Motos save(@RequestBody Motos moto);

    @GetMapping("/usuario/{usuarioId}")
    public List<Motos> getMotos(@PathVariable("usuarioId") int usuarioId);
}
