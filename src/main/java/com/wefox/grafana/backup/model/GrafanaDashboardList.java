package com.wefox.grafana.backup.model;

import java.util.ArrayList;

public class GrafanaDashboardList {
    public int id;
    public String uid;
    public String title;
    public String uri;
    public String url;
    public String slug;
    public String type;
    public ArrayList<String> tags;
    public boolean isStarred;
    public int sortMeta;
}
