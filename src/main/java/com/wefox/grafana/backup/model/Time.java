package com.wefox.grafana.backup.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Time{
    public String from;
    @JsonProperty("to")
    public String myto;
}
