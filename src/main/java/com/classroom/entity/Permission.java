package com.classroom.entity;

import java.util.Date;

public class Permission {
    private Integer id;

    private String name;

    private Byte value;

    private Integer parentPermissionId;

    private String url;

    private Byte deleted;

    private Date createAt;

    private Date updatedAt;

    private Permission parentPermission;

    public Permission getParentPermission() {
        return parentPermission;
    }

    public void setParentPermission(Permission parentPermission) {
        this.parentPermission=parentPermission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public Integer getParentPermissionId() {
        return parentPermissionId;
    }

    public void setParentPermissionId(Integer parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Permission(){}

    public Permission(Integer id) {
        this.id = id;
    }
}