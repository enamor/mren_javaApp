/*
 * CategoryOne.java
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
public class CategoryOne {

    //一级分类 ID
    private Long id;
    private String cid;
    private String name;
    //是否显示 1 显示 ， 0不显示
    private Integer state;
    //排序用
    private Integer sortId;

    public CategoryOne(Long id, String cid, String name, Integer state, Integer sortId) {
        this.id = id;
        this.cid = cid;
        this.name = name;
        this.state = state;
        this.sortId = sortId;
    }
    public CategoryOne() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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