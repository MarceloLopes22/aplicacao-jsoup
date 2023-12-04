package com.example.jsoup.services;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> login = new HashMap<>();
        //login.put("usarname", loginDTO.getLogin());
        //login.put("password", loginDTO.getPassword());

        login.put("usarname", "05941244410");
        login.put("password", "Expedit123");

        Connection.Response doc = null;
        try {
            doc = Jsoup.connect("https://pje.tjpe.jus.br/1g/login.seam")
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .data(login)
                    .method(Connection.Method.POST)
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print(doc.statusMessage());
    }
}
