package com.rjr.library02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjr.library02.entities.Autore;

@RestController
@RequestMapping("/api/v1/library/authors")
public class AutoreController extends GenericController<Autore>{

}
