package br.com.zup.recarga.controller;

import br.com.zup.recarga.controller.dto.RecargaRequest;
import br.com.zup.recarga.controller.dto.RecargaResponse;
import br.com.zup.recarga.producer.RecargaCelularDTO;
import br.com.zup.recarga.producer.RecargaCelularProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/recarga")
public class RecargaCelularController {

    @Autowired
    private RecargaCelularProducer producer;

    @PostMapping
    public ResponseEntity<RecargaResponse> recarga(@Valid @RequestBody RecargaRequest request) {

        RecargaCelularDTO recargaDTO = new RecargaCelularDTO(request);

        producer.send(recargaDTO);

        return ResponseEntity.ok().build();
    }
}
