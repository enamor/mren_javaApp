/*
 * PhotoAlbum.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package org.zn.photos.entity;

/**
 * 
 * 
 * @author 
 * @version 1.0 2016-11-28
 */
public class PhotoAlbum {

    //相册ID
    private Long id;
    private String uuid;
    private String albumPath;
    //相册 封面图片URL
    private String imageUrl;
    //UUID作为唯一键,用来做业务查询
    private String title;
    private Integer imageWidth;
    private Integer imageHeight;
    //图片的大小
    private Long imageSize;
    //该相册 是否展示 1
    private Integer state;
    private Long watch;
    //图片来源
    private String source;
    //创建时间
    private String createdTime;

    public PhotoAlbum(Long id, String uuid, String albumPath, String imageUrl, String title, Integer imageWidth, Integer imageHeight, Long imageSize, Integer state, Long watch, String source, String createdTime) {
        this.id = id;
        this.uuid = uuid;
        this.albumPath = albumPath;
        this.imageUrl = imageUrl;
        this.title = title;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize;
        this.state = state;
        this.watch = watch;
        this.source = source;
        this.createdTime = createdTime;
    }
    public PhotoAlbum() {
    	super();
    	this.state = 1;
        this.watch = (long) 0;
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
    public String getAlbumPath() {
        return albumPath;
    }
    public void setAlbumPath(String albumPath) {
        this.albumPath = albumPath == null ? null : albumPath.trim();
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public Long getWatch() {
        return watch;
    }
    public void setWatch(Long watch) {
        this.watch = watch;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
    public String getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime == null ? null : createdTime.trim();
    }
}