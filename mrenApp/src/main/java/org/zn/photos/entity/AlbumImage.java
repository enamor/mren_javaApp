/*
 * AlbumImage.java
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
public class AlbumImage {

    private Long id;
    private String uuid;
    //相册ID
    private String photoUuid;
    private String imageUrl;
    private Integer imageWidth;
    private Integer imageHeight;
    private Long imageSize;
    private Long praisedNumber;
    private Integer state;

    public AlbumImage(Long id, String uuid, String photoUuid, String imageUrl, Integer imageWidth, Integer imageHeight, Long imageSize, Long praisedNumber, Integer state) {
        this.id = id;
        this.uuid = uuid;
        this.photoUuid = photoUuid;
        this.imageUrl = imageUrl;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize;
        this.praisedNumber = praisedNumber;
        this.state = state;
    }
    public AlbumImage() {
        super();
        praisedNumber = (long) 0;
        state = 1;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
    public String getPhotoUuid() {
        return photoUuid;
    }
    public void setPhotoUuid(String photoUuid) {
        this.photoUuid = photoUuid == null ? null : photoUuid.trim();
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }
    public Integer getImageWidth() {
        return imageWidth;
    }
    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }
    public Integer getImageHeight() {
        return imageHeight;
    }
    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }
    public Long getImageSize() {
        return imageSize;
    }
    public void setImageSize(Long imageSize) {
        this.imageSize = imageSize;
    }
    public Long getPraisedNumber() {
        return praisedNumber;
    }
    public void setPraisedNumber(Long praisedNumber) {
        this.praisedNumber = praisedNumber;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
}