package com.eventos.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventos.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{

}
