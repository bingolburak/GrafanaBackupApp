package com.wefox.grafana.backup.model;

import java.util.Date;

public class Meta{
    public String type;
    public boolean canSave;
    public boolean canEdit;
    public boolean canAdmin;
    public boolean canStar;
    public boolean canDelete;
    public String slug;
    public String url;
    public Date expires;
    public Date created;
    public Date updated;
    public String updatedBy;
    public String createdBy;
    public int version;
    public boolean hasAcl;
    public boolean isFolder;
    public int folderId;
    public String folderUid;
    public String folderTitle;
    public String folderUrl;
    public boolean provisioned;
    public String provisionedExternalId;
    public AnnotationsPermissions annotationsPermissions;
    public String publicDashboardAccessToken;
    public boolean publicDashboardEnabled;
}
