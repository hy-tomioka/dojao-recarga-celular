package br.com.zup.recarga.dominio.modelo;

import br.com.zup.recarga.dominio.enums.TipoOperacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Transacao {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull @Column(unique = true)
    private UUID uuid = UUID.randomUUID();

    @NotNull @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoOperacao operacao;

    @NotNull @Column(nullable = false)
    private BigDecimal valor;

    @NotBlank
    private String numeroConta;
}
