/*
 * PhotoType.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-19 Created
 */
package org.zn.photos.entity;

/**
 * 
 * 
 * @author 
 * @version 1.0 2016-11-19
 */
public class PhotoType {

    private Long id;
    //类别ID
    private String categoryId;
    private String photoUuid;

    public PhotoType(Long id, String categoryId, String photoUuid) {
        this.id = id;
        this.categoryId = categoryId;
        this.photoUuid = photoUuid;
    }
    public PhotoType() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }
    public String getPhotoUuid() {
        return photoUuid;
    }
    public void setPhotoUuid(String photoUuid) {
        this.photoUuid = photoUuid == null ? null : photoUuid.trim();
    }
}