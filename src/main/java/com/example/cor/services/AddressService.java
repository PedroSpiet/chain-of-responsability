package com.example.cor.services;

import com.example.cor.chain.ServiceLink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressService extends ServiceLink {

    @Override
    public void handle(String message) {
        log.info("AddressService Service");
        log.info("Mensagem que chegou ao AddressService: {}", message);
    }
}
