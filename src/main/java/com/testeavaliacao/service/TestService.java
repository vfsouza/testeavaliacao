package com.testeavaliacao.service;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TestService {
    static String webService = "http://localhost:4502/bin/sistema/product";
    static Integer successCode = 200;

    public static String requisition() {
        String json = null;

        try {
            URL url = new URL(webService);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Basic admin:admin");

            System.out.println(connection.getResponseCode());
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException();
            }

            Scanner sc = new Scanner(connection.getInputStream());
            String dados = null;

            while (sc.hasNextLine()) {
                dados += sc.next();
            }

            json = new Gson().fromJson(dados, String.class);
            System.out.println(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }
}
