package com.moto_service.demo.service;

import com.moto_service.demo.entity.Moto;
import com.moto_service.demo.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getMotos() {
        return motoRepository.findAll();
    }


    public Moto getMotoById(int id) {
        return motoRepository.findById(id).orElse(null);
    }

    public Moto createMoto(Moto moto) {
        return motoRepository.save(moto);
    }


    public List<Moto> getMotosByUsuarioId(int usuarioId) {
        return motoRepository.findByUsuarioId(usuarioId);
    }





}
