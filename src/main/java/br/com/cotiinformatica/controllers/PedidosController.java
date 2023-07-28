package br.com.cotiinformatica.controllers;

import br.com.cotiinformatica.commons.pedidos.dto.PedidoDto;
import br.com.cotiinformatica.dtos.PedidoResponseDto;
import br.com.cotiinformatica.producers.PagamentoProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

	@Autowired
	private PagamentoProducer pagamentoProducer;

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("{message}")
	public String get(@PathVariable("message") String message) {
		pagamentoProducer.send(message);
		return "Dados enviados com sucesso!";
	}

	@PostMapping
	public ResponseEntity<PedidoResponseDto> post(@RequestBody PedidoDto request) {

		String message = null;

		try{
			message = objectMapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		pagamentoProducer.send(message);

		PedidoResponseDto response = new PedidoResponseDto();
		response.setMensagem("Pedido realizado com sucesso!");
		response.setStatus("created");
		response.setNumeroPedido(UUID.randomUUID().toString());

		return ResponseEntity.status(201).body(response);

	}
}
