/*
 * CategoryThree.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-18 Created
 */
package org.zn.category.entity;

/**
 * 
 * 
 * @author 
 * @version 1.0 2016-11-18
 */
public class CategoryThree {

    //三级分类
    private Long id;
    private String cid;
    //所属上级目录ID
    private String parentId;
    private String name;
    //是否显示 0不显示
    private Integer state;
    //排序用
    private Integer sortId;

    public CategoryThree(Long id, String cid, String parentId, String name, Integer state, Integer sortId) {
        this.id = id;
        this.cid = cid;
        this.parentId = parentId;
        this.name = name;
        this.state = state;
        this.sortId = sortId;
    }
    public CategoryThree() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public Integer getSortId() {
        return sortId;
    }
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
}