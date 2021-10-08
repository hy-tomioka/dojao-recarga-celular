package br.com.zup.recarga.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class RecargaRequest {

    @NotBlank
    private final String idCliente;

    @NotBlank
    private final String numeroConta;

    @NotNull
    @Positive
    private final BigDecimal valor;

    @NotNull
    private final UUID idTransacao;

    @NotNull
    private final Instant dataTransacao;

    @NotBlank
    private final String numeroCelular;

    @JsonCreator(mode = PROPERTIES)
    public RecargaRequest(String idCliente, String numeroConta, BigDecimal valor, String numeroCelular, UUID idTransacao, Instant dataTransacao) {
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
        this.valor = valor;
        this.numeroCelular = numeroCelular;
        this.idTransacao = idTransacao;
        this.dataTransacao = dataTransacao;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public UUID getIdTransacao() {
        return idTransacao;
    }

    public Instant getDataTransacao() {
        return dataTransacao;
    }
}
