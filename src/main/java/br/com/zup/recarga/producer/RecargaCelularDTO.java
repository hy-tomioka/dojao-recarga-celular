package br.com.zup.recarga.producer;

import br.com.zup.recarga.controller.dto.RecargaRequest;

import java.math.BigDecimal;
import java.time.Instant;

public class RecargaCelularDTO {

    private final String idCliente;

    private final String numeroConta;

    private final TipoTransacao operacao;

    private final BigDecimal valor;

    private final Instant data;

    public RecargaCelularDTO(RecargaRequest transacao) {
        this.idCliente = transacao.getIdCliente();
        this.numeroConta = transacao.getNumeroConta();
        this.operacao = TipoTransacao.RECARGA_CELULAR;
        this.valor = transacao.getValor();
        this.data = transacao.getDataTransacao();
    }

    public TipoTransacao getOperacao() {
        return operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Instant getData() {
        return data;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
