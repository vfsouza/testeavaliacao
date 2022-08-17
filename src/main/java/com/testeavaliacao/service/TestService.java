package com.testeavaliacao.service;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            json = new Gson().fromJson(br, String.class);
            System.out.println(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }
}
