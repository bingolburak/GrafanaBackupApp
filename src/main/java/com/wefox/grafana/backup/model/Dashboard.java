package com.wefox.grafana.backup.model;

import java.util.ArrayList;

public class Dashboard{
    public boolean canAdd;
    public boolean canEdit;
    public boolean canDelete;
    public Annotations annotations;
    public boolean editable;
    public Object gnetId;
    public int graphTooltip;
    public boolean hideControls;
    public int id;
    public ArrayList<Object> links;
    public String refresh;
    public ArrayList<Row> rows;
    public int schemaVersion;
    public String style;
    public ArrayList<String> tags;
    public Templating templating;
    public Time time;
    public Timepicker timepicker;
    public String timezone;
    public String title;
    public String uid;
    public int version;
}
