package com.wefox.grafana.backup.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.wefox.grafana.backup.model.GrafanaDashboard;
import com.wefox.grafana.backup.model.GrafanaDashboardList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BackupController {
    private GrafanaClient client;
    private WebClient webClient;
    @Value("${grafana.url}")
    private String grafanaUrl;
    @Value("${grafana.username}")
    private String grafanaUsername;
    @Value("${grafana.password}")
    private String grafanaPassword;
    @Value("${grafana.port}")
    private int grafanaPort;
    @GetMapping("/getDashboardList")
    public Mono<GrafanaDashboardList[]> getDashboardList() throws IOException {
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAYV6MVGZCZZI2YIHG",
                "tRKU6Pa3FkRlGBN9HOh9q16UW7mtyjpCXkxXTld7"
        );
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.EU_CENTRAL_1)
                .build();
        List<Bucket> buckets = s3client.listBuckets();
        for(Bucket bucket : buckets) {
            System.out.println(bucket.getName());
            s3client.putObject(
                    bucket.getName(),
                    "Document/hello.txt",
                    new File("/Users/burak.bingoel/Documents/hello.txt")
            );
        }
        webClient = new GrafanaClient(grafanaUrl, grafanaPort, grafanaUsername, grafanaPassword).createWebClient();
        Mono<GrafanaDashboardList[]> response = webClient.get().uri("/api/search?query=%").header("Accept","application/json")
                .retrieve().bodyToMono(GrafanaDashboardList[].class);
        GrafanaDashboardList[] gdList = response.block();
        Set<String> setUid = new HashSet<>();
        for (GrafanaDashboardList gd : gdList) {
            System.out.println(gd.uid);
            setUid.add(gd.uid.toString());
        }
        for (String uid : setUid) {
            String responseJson = webClient.get().uri("/api/dashboards/uid/"+uid).header("Accept", "application/json")
                    .retrieve().bodyToMono(String.class).block();
            System.out.println(responseJson);
            Mono<GrafanaDashboard> gdResponse = webClient.get().uri("/api/dashboards/uid/"+uid).header("Accept", "application/json")
                    .retrieve().bodyToMono(GrafanaDashboard.class);
            System.out.println(gdResponse.block());
            var file = new FileWriter("/Users/burak.bingoel/Documents/"+gdResponse.block().dashboard.title+"uid.json");
            file.write(responseJson);
        }
        return response;
    }
    @GetMapping("/getDashboardById/{id}")
    public void getDashboardById(String id){
        /*client = new  GrafanaClient("http://localhost:3000","admin","prom-operator");
        webClient = client.createWebClient();
        Mono<GrafanaDashboard> response = webClient.get().uri("/api/dashboards/uid/"+id).header("Accept","application/json")
                .retrieve().bodyToMono(GrafanaDashboard.class);
        GrafanaDashboard gd = response.block();*/
    }
}
