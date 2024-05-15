package com.sisencuesta.services.Impl;

import com.sisencuesta.models.Encuesta;
import com.sisencuesta.repository.EncuestaRepository;
import com.sisencuesta.services.EncuestaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EncuestaServiceImpl implements EncuestaService {

    @Autowired
    private EncuestaRepository encuestaRepository;


    @Override
    public Encuesta crearEncuesta(String titlo) {
        Encuesta encuesta = new Encuesta();
        encuesta.setTitulo(titlo);
        return encuestaRepository.save(encuesta);
    }

    @Override
    public List<Encuesta> obtenerTodasLasEncuestas() {
        return encuestaRepository.findAll();
    }

    @Override
    public Optional<Encuesta> obtenerDetallesEncuesta(Long encuestaId) {
        return encuestaRepository.findById(encuestaId);
    }

    @Override
    public Encuesta actualizarEncuesta(Long encuestaId, String nuevoTitulo) {
        return encuestaRepository.findById(encuestaId)
                .map(encuesta -> {
                    encuesta.setTitulo(nuevoTitulo);
                    return encuestaRepository.save(encuesta);
                }).orElse(null);
    }

    @Override
    public void eliminarEncuesta(Long encuestaId) {
           encuestaRepository.deleteById(encuestaId);
    }
}
