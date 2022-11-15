package com.wefox.grafana.backup.controller;

import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

public class GrafanaClient {
    private String grafanaHost;
    private int grafanaPort;
    private String username;
    private String password;

    public GrafanaClient(String grafanaHost, int grafanaPort, String username, String password) {
        this.grafanaHost = grafanaHost;
        this.grafanaPort = grafanaPort;
        this.username = username;
        this.password = password;
    }

    public WebClient createWebClient(){
        String url = "http://" +grafanaHost+":"+grafanaPort;
        WebClient client = WebClient.builder().baseUrl(url)
                .defaultHeader("Content-Type", "application/json")
                .filter(ExchangeFilterFunctions.basicAuthentication(username,password))
                .build();
        return client;
    }
    public String getGrafanaHost() {
        return grafanaHost;
    }

    public void setGrafanaHost(String grafanaHost) {
        this.grafanaHost = grafanaHost;
    }

    public int getGrafanaPort() {
        return grafanaPort;
    }

    public void setGrafanaPort(String grafanaPort) {
        this.grafanaHost = grafanaPort;
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
