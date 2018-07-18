package com.rjr.library02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjr.library02.entities.Cliente;

@RestController
@RequestMapping("/api/v1/library/customers")
public class ClienteController extends GenericController<Cliente>{

}
