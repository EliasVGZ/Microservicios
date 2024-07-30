package carro_service.service;

import carro_service.entity.Carro;
import carro_service.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getCarros() {
        return carroRepository.findAll();
    }

    public Carro getCarroById(int id) {
        return carroRepository.findById(id).orElse(null);
    }

    public Carro createCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> getCarrosByUsuarioId(int usuarioId) {
        return carroRepository.findByUsuarioId(usuarioId);
    }



}
