package com.wefox.grafana.backup.controller;

import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

public class GrafanaClient {
    private String grafanaUrl;
    private String username;
    private String password;

    public GrafanaClient(String grafanaUrl, String username, String password) {
        this.grafanaUrl = grafanaUrl;
        this.username = username;
        this.password = password;
    }

    public WebClient createWebClient(){
        WebClient client = WebClient.builder().baseUrl(grafanaUrl)
                .defaultHeader("Content-Type", "application/json")
                .filter(ExchangeFilterFunctions.basicAuthentication(username,password))
                .build();
        return client;
    }
    public String getGrafanaUrl() {
        return grafanaUrl;
    }

    public void setGrafanaUrl(String grafanaUrl) {
        this.grafanaUrl = grafanaUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
