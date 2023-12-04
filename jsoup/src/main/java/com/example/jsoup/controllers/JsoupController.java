package com.example.jsoup.controllers;

import com.example.jsoup.dto.LoginDTO;
import com.example.jsoup.dto.ResponseDTO;
import com.example.jsoup.services.JsoupService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(value = "/login")
    public ResponseEntity<?> create(HttpServletRequest request, @Valid @RequestBody LoginDTO loginDTO) {
        return this.service.login(loginDTO);
    }
}
