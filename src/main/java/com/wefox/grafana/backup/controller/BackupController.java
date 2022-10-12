package com.wefox.grafana.backup.controller;

import com.wefox.grafana.backup.model.GrafanaDashboard;
import com.wefox.grafana.backup.model.GrafanaDashboardList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Set;

@RestController
public class BackupController {
    private GrafanaClient client;
    private WebClient webClient;
    @GetMapping("/getDashboardList")
    public Mono<GrafanaDashboardList[]> getDashboardList(){
        client = new  GrafanaClient("http://localhost:3000","admin","prom-operator");
        webClient = client.createWebClient();
        Mono<GrafanaDashboardList[]> response = webClient.get().uri("/api/search?query=%").header("Accept","application/json")
                .retrieve().bodyToMono(GrafanaDashboardList[].class);
        GrafanaDashboardList[] gdList = response.block();
        Set<String> setList = null;
        for (GrafanaDashboardList gd : gdList) {
            System.out.println(gd.uid);
            setList.add(gd.uid);
        }
        return response;
    }
    @GetMapping("/getDashboardById/{id}")
    public void getDashboardById(String id){
        client = new  GrafanaClient("http://localhost:3000","admin","prom-operator");
        webClient = client.createWebClient();
        Mono<GrafanaDashboard> response = webClient.get().uri("/api/dashboards/uid/"+id).header("Accept","application/json")
                .retrieve().bodyToMono(GrafanaDashboard.class);
        GrafanaDashboard gd = response.block();
    }
}
