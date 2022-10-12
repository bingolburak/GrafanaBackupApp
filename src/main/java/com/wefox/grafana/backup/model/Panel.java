package com.wefox.grafana.backup.model;

import java.util.ArrayList;

public class Panel{
    public AliasColors aliasColors;
    public boolean bars;
    public int dashLength;
    public boolean dashes;
    public String datasource;
    public int fill;
    public int id;
    public Legend legend;
    public boolean lines;
    public int linewidth;
    public ArrayList<Object> links;
    public String nullPointMode;
    public boolean percentage;
    public int pointradius;
    public boolean points;
    public String renderer;
    public ArrayList<Object> seriesOverrides;
    public int spaceLength;
    public int span;
    public boolean stack;
    public boolean steppedLine;
    public ArrayList<Style> styles;
    public ArrayList<Target> targets;
    public ArrayList<Object> thresholds;
    public Object timeFrom;
    public Object timeShift;
    public String title;
    public Tooltip tooltip;
    public String transform;
    public String type;
    public Xaxis xaxis;
    public ArrayList<Yaxis> yaxes;
}
