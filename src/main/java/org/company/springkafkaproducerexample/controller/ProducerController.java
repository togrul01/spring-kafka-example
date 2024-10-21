package org.company.springkafkaproducerexample.controller;

import lombok.RequiredArgsConstructor;
import org.company.springkafkaproducerexample.dto.Product;
import org.company.springkafkaproducerexample.service.ProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("producer")
public class ProducerController {

    private final ProducerService producerService;

    @GetMapping
    public String healthCheck(@RequestBody String message) {
        producerService.send(message);
        return "Message is send successfully";
    }

    @PostMapping
    public Product sendProductMessage(@RequestBody Product message) {
        producerService.send(message);
        return message;
    }


}