package carro_service.controller;

import carro_service.entity.Carro;
import carro_service.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroService.getCarros();
        if(carros.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(carros);
    }

    @PostMapping
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){

        Carro nuevoCarro = carroService.createCarro(carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarroPorId(@PathVariable ("id") int id){
        Carro carro = carroService.getCarroById(id);
        if(carro == null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(carro);
    }

    @GetMapping("usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> obtenerCarrosPorUsuarioId(@PathVariable ("usuarioId") int id){
        List<Carro> carros = carroService.getCarrosByUsuarioId(id);
        if(carros.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carros);
    }



}
