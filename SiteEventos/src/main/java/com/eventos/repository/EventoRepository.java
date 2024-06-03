package com.eventos.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventos.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{  //estende a classe crud e essa interface que é apenas instanciada pode ser utilizada atraves de metodos
   Evento findByCodigo(long codigo);                                        //antoando metodo getByCodigo podendo utiliza-lo no eventoController//importando a classe crud e a entidade evento atraves do autowired implementado no eventocontroller
	                                                                        //a notação autowired faz uma injeção de dependencias, fazendo que toda vez que for utilizada a interface ela
}                                                                          //crie uma nova instancia
