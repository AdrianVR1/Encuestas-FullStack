package com.sisencuesta.services.Impl;


import com.sisencuesta.models.Pregunta;
import com.sisencuesta.models.Respuesta;
import com.sisencuesta.repository.PreguntaRepository;
import com.sisencuesta.repository.RespuestaRepository;
import com.sisencuesta.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public Respuesta agregarRespuestaAPregunta(Long preguntaId, String contenido) {
        Optional<Pregunta> preguntaOptional = preguntaRepository.findById(preguntaId);
        return preguntaOptional.map(pregunta -> {
            Respuesta respuesta = new Respuesta(null, contenido,pregunta);
            pregunta.getRespuestas().add(respuesta);
            preguntaRepository.save(pregunta);
            return respuesta;
        }).orElse(null);
    }

    @Override
    public List<Respuesta> obtenerRespuestaPorPregunta(Long preguntaId) {
        return respuestaRepository.findByPreguntaId(preguntaId);
    }

    @Override
    public Optional<Respuesta> obtenerDetallesRespuesta(Long respuestaId) {
        return respuestaRepository.findById(respuestaId);
    }

    @Override
    public Respuesta actualizarRespuesta(Long respuestaId, String nuevoContenido) {
        return respuestaRepository.findById(respuestaId).map(respuesta -> {
            respuesta.setContenido(nuevoContenido);
            return respuestaRepository.save(respuesta);
        }).orElseThrow(null);
    }

    @Override
    public void eliminarRespuesta(Long respuestaId) {
        respuestaRepository.findById(respuestaId).ifPresent(respuesta -> {
            Pregunta pregunta = respuesta.getPregunta();
            pregunta.getRespuestas().remove(respuesta);

            respuestaRepository.deleteById(respuestaId);
            preguntaRepository.save(pregunta);
        });


    }
}
