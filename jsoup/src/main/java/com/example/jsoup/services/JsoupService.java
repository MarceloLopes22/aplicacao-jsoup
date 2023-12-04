package com.example.jsoup.services;

import com.example.jsoup.dto.LoginDTO;
import com.example.jsoup.dto.ResponseDTO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.util.HashMap;

@Service
public class JsoupService {

    public static final String URL = "https://pt.wikipedia.org/wiki/Dengue";

    public static final String URL_TJPE = "https://pje.tjpe.jus.br/1g/login.seam";
    private ResponseDTO responseDTO;
    public ResponseEntity<ResponseDTO> ler() {
        try {
            Document doc = Jsoup.connect(URL).get();

            Elements tituloPrincipal = doc.getElementsByClass("mw-page-title-main");
            String etmologia = doc.getElementById("Etimologia").text();
            String historia = doc.getElementById("História").text();
            String sinais = doc.getElementById("Sinais_e_sintomas").text();
            String cursoClinico = doc.getElementById("Curso_clínico").text();
            String complicaçõesRelacionadas = doc.getElementById("Complicações_relacionadas").text();
            String causas = doc.getElementById("Causas").text();
            String virologia = doc.getElementById("Virologia").text();
            String transmissao = doc.getElementById("Transmissão").text();
            String predisposicao = doc.getElementById("Predisposição").text();
            String diagnostico = doc.getElementById("Diagnóstico").text();
            String classificacao = doc.getElementById("Classificação").text();
            String testesLaboratorio = doc.getElementById("Testes_de_laboratório").text();
            String tratamento = doc.getElementById("Tratamento").text();
            String prevencao = doc.getElementById("Prevenção").text();
            String pesquisa = doc.getElementById("Pesquisa").text();
            String epidemiologia = doc.getElementById("Epidemiologia").text();
            String brasil = doc.getElementById("Brasil").text();
            responseDTO = ResponseDTO
                    .builder()
                    .tituloPrincipal(tituloPrincipal.text())
                    .etmologia(etmologia)
                    .historia(historia)
                    .sinais(sinais)
                    .cursoClinico(cursoClinico)
                    .complicaçõesRelacionadas(complicaçõesRelacionadas)
                    .causas(causas)
                    .virologia(virologia)
                    .transmissao(transmissao)
                    .predisposicao(predisposicao)
                    .diagnostico(diagnostico)
                    .classificacao(classificacao)
                    .testesLaboratorio(testesLaboratorio)
                    .tratamento(tratamento)
                    .prevencao(prevencao)
                    .pesquisa(pesquisa)
                    .epidemiologia(epidemiologia)
                    .brasil(brasil)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(responseDTO);
    }

    public ResponseEntity<?> login(LoginDTO loginDTO) {
        HashMap<String,String> loginHashMap = new HashMap<>();

        loginHashMap.put("usarname", loginDTO.getLogin());
        loginHashMap.put("password", loginDTO.getPassword());
        Connection.Response doc = null;
        try {
            doc = Jsoup.connect(URL_TJPE)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .data(loginHashMap)
                    .method(Connection.Method.POST)
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return ResponseEntity.ok(doc.statusMessage());
    }
}
