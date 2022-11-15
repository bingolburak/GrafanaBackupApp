package com.wefox.grafana.backup.model;

import java.util.ArrayList;

public class Dashboard{
    public boolean canAdd;
    public boolean canEdit;
    public boolean canDelete;
    public boolean editable;
    public int graphTooltip;
    public boolean hideControls;
    public int id;
    public String refresh;
    public int schemaVersion;
    public String style;
    public ArrayList<String> tags;
    public String timezone;
    public String title;
    public String uid;
    public int version;
}
