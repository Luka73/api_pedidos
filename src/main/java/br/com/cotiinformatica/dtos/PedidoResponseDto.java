package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class PedidoResponseDto {
    private String status;
    private String numeroPedido;
    private String mensagem;
}
