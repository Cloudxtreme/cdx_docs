package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.sql.Blob;

/**
 * MenuItem generated by hbm2java
 */
public class MenuItem implements java.io.Serializable {

	private MenuItemId id;
	private ParentMenu parentMenu;
	private OcxLoad ocxLoad;
	private String caption;
	private String ocxName;
	private String urlName;
	private String screenName;
	private Boolean modal;
	private String iconName;
	private Blob iconBlob;

	public MenuItem() {
	}

	public MenuItem(MenuItemId id, ParentMenu parentMenu, String caption) {
		this.id = id;
		this.parentMenu = parentMenu;
		this.caption = caption;
	}

	public MenuItem(MenuItemId id, ParentMenu parentMenu, OcxLoad ocxLoad,
			String caption, String ocxName, String urlName, String screenName,
			Boolean modal, String iconName, Blob iconBlob) {
		this.id = id;
		this.parentMenu = parentMenu;
		this.ocxLoad = ocxLoad;
		this.caption = caption;
		this.ocxName = ocxName;
		this.urlName = urlName;
		this.screenName = screenName;
		this.modal = modal;
		this.iconName = iconName;
		this.iconBlob = iconBlob;
	}

	public MenuItemId getId() {
		return this.id;
	}

	public void setId(MenuItemId id) {
		this.id = id;
	}

	public ParentMenu getParentMenu() {
		return this.parentMenu;
	}

	public void setParentMenu(ParentMenu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public OcxLoad getOcxLoad() {
		return this.ocxLoad;
	}

	public void setOcxLoad(OcxLoad ocxLoad) {
		this.ocxLoad = ocxLoad;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getOcxName() {
		return this.ocxName;
	}

	public void setOcxName(String ocxName) {
		this.ocxName = ocxName;
	}

	public String getUrlName() {
		return this.urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Boolean getModal() {
		return this.modal;
	}

	public void setModal(Boolean modal) {
		this.modal = modal;
	}

	public String getIconName() {
		return this.iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public Blob getIconBlob() {
		return this.iconBlob;
	}

	public void setIconBlob(Blob iconBlob) {
		this.iconBlob = iconBlob;
	}

}