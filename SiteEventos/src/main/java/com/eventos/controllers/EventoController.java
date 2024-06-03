package com.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventos.models.Evento;
import com.eventos.repository.EventoRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller

public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value="/cadastrarEvento", method = RequestMethod.GET) //requisição através do metodo GET que retorna um formulario
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method = RequestMethod.POST) //requisição que ao apertar o salvar dos dados é enviada
    public String form(Evento evento){

        eventoRepository.save(evento); //persistencia do metodo
        
        return "redirect:/cadastrarEvento"; //redirecionamento para o metodo get
    }

    @RequestMapping("/eventos") //quando o cliente digitar /eventos vai buscar as infos do bd
    public ModelAndView listaEventos(){ //vai enviar uma requisição e receber a lista de eventos
        ModelAndView modelAndView = new ModelAndView("index");  //obj modelandview, passando a pagina onde ele renderiza os dados do evento
        Iterable<Evento> eventos = eventoRepository.findAll(); //iterable pois eh uma lista, recebendo um evento repository, find all, buscando uma lista de eventos
        modelAndView.addObject("eventos", eventos); //vai reconhecer a palavra entre chaves com o nome do iterable e da div no html, essa lista de eventos então é passada para a view
        return modelAndView;
    }
    
    @RequestMapping("/{codigo}") //redireciona através do codigo os detalhes de cada evento
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) { //importando o pathvariable para receber como parametro, esse codigo fara uma busca no bd
    	    Evento evento = eventoRepository.findByCodigo(codigo);  //busca o codigo e guarda na variavel evento                                                          //porem essa busca é através de um evento especifico e não da lista toda
    	    ModelAndView modelAndView = new ModelAndView("evento/detalhesEvento"); //instanciando modelandview para a pagina html
    	    modelAndView.addObject("evento", evento);
    	    return modelAndView;
    }
}


