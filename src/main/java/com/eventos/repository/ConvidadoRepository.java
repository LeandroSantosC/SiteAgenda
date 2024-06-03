package com.eventos.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventos.models.Convidado;
import com.eventos.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{

    Iterable<Convidado> findByEvento(Evento evento);
    
}
