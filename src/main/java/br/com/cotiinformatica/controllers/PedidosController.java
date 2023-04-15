package br.com.cotiinformatica.controllers;

import br.com.cotiinformatica.producers.PagamentoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

	@Autowired
	private PagamentoProducer pagamentoProducer;

	@GetMapping("{message}")
	public String get(@PathVariable("message") String message) {
		pagamentoProducer.send(message);
		return "Dados enviados com sucesso!";
	}

}
