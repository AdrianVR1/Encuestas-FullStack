package com.sisencuesta.repository;

import com.sisencuesta.models.Pregunta;
import com.sisencuesta.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByPreguntaId(Long preguntaId);
}
