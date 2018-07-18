package com.rjr.library02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjr.library02.entities.Libro;

@RestController
@RequestMapping("/api/v1/library/books")
public class LibroController extends GenericController<Libro>{

}
