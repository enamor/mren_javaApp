/*
 * VersionControl.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package org.zn.user.entity;

/**
 * 
 * 
 * @author 
 * @version 1.0 2016-11-29
 */
public class VersionControl {

    private Integer id;
    //app版本号
    private String appVersion;
    //状态 0、正常 1、需要强升 2、上线
    private Integer appState;
    //设备 iOS 安卓
    private String appDevice;
    //版本描述
    private String appDescription;

    public VersionControl(Integer id, String appVersion, Integer appState, String appDevice, String appDescription) {
        this.id = id;
        this.appVersion = appVersion;
        this.appState = appState;
        this.appDevice = appDevice;
        this.appDescription = appDescription;
    }
    public VersionControl() {
    	super();
        this.appDevice = "iOS";
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAppVersion() {
        return appVersion;
    }
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }
    public Integer getAppState() {
        return appState;
    }
    public void setAppState(Integer appState) {
        this.appState = appState;
    }
    public String getAppDevice() {
        return appDevice;
    }
    public void setAppDevice(String appDevice) {
        this.appDevice = appDevice == null ? null : appDevice.trim();
    }
    public String getAppDescription() {
        return appDescription;
    }
    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription == null ? null : appDescription.trim();
    }
}