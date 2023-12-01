package com.example.jsoup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseDTO {
    private String tituloPrincipal;

    private String etmologia;

    private String historia;

    private String sinais;

    private String cursoClinico;

    private String complicaçõesRelacionadas;

    private String causas;

    private String virologia;

    private String transmissao;

    private String predisposicao;

    private String diagnostico;

    private String classificacao;

    private String testesLaboratorio;

    private String tratamento;

    private String prevencao;

    private String pesquisa;

    private String epidemiologia;

    private String brasil;
}
