package br.com.zup.recarga.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RecargaCelularProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecargaCelularProducer.class);

    private final KafkaTemplate<String, RecargaCelularDTO> kafkaTemplate;

    @Value("${topico.transacoes}")
    private String topic;

    public RecargaCelularProducer(KafkaTemplate<String, RecargaCelularDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(RecargaCelularDTO recargaDTO){
        kafkaTemplate.send(topic, recargaDTO).addCallback(
                success -> LOGGER.info("Mensagem enviada " + success.getProducerRecord().value()),
                failure -> LOGGER.info("Falha ao enviar mensagem " + failure.getMessage())
        );
    }
}
