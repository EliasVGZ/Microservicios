package com.moto_service.demo.controller;

import com.moto_service.demo.entity.Moto;
import com.moto_service.demo.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {


    @Autowired
    private MotoService motoService;


    //Mapear todos los motos
    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos(){
        List<Moto> motos = motoService.getMotos();
        if(motos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(motos);
    }

    //Guardar moto
    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){

        Moto nuevaMoto = motoService.createMoto(moto);
        return ResponseEntity.ok(nuevaMoto);
    }


    //Buscar moto por id
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMotoPorId(@PathVariable ("id") int id){
        Moto moto = motoService.getMotoById(id);
        if(moto == null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(moto);
    }

    //Buscar moto por usuarioId
    @GetMapping("usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> obtenerMotosPorUsuarioId(@PathVariable ("usuarioId") int id){
        List<Moto> motos = motoService.getMotosByUsuarioId(id);
        if(motos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motos);
    }




}
