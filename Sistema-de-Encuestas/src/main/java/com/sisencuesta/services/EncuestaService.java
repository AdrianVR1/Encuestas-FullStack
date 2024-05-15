package com.sisencuesta.services;

import com.sisencuesta.models.Encuesta;

import java.util.List;
import java.util.Optional;

public interface EncuestaService {

    Encuesta crearEncuesta(String titulo);
    List<Encuesta>obtenerTodasLasEncuestas();
    Optional<Encuesta>obtenerDetallesEncuesta(Long encuestaId);
    Encuesta actualizarEncuesta(Long encuestaId, String nuevoTitulo);
    void eliminarEncuesta(Long encuestaId);


}
