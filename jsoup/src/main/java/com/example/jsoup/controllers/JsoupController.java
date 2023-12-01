package com.example.jsoup.controllers;

import com.example.jsoup.dto.ResponseDTO;
import com.example.jsoup.services.JsoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class JsoupController {

    @Autowired
    private JsoupService service;

    @GetMapping(value = "/ler/pagina")
    public ResponseEntity<ResponseDTO> ler() {
        return this.service.ler();
    }
}
