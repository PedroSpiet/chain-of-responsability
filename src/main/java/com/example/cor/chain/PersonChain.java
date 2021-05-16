package com.example.cor.chain;


import com.example.cor.services.AddressService;
import com.example.cor.services.PersonService;
import com.example.cor.services.ServiceC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class PersonChain {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ServiceC serviceC;

    @PostConstruct
    public void setExecutationOrder() {
        personService
                .andThen(addressService)
                .andThen(serviceC);
    }

    public void handle(String message) {
        log.info("Iniciando Cadeia: ");
        personService.doNext(message);
    }
}
