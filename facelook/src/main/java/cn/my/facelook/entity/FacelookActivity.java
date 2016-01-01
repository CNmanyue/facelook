package cn.my.facelook.entity;

import java.sql.Timestamp;

/**
 * FacelookActivity entity. @author MyEclipse Persistence Tools
 */

public class FacelookActivity implements java.io.Serializable {

	// Fields

	private Integer faId;
	private FacelookUser facelookUser;
	private FacelookPhoto facelookPhoto;
	private Timestamp faTime;
	private Integer faType;
	private Integer fcId;
	private Integer fmId;

	// Constructors

	/** default constructor */
	public FacelookActivity() {
	}

	/** full constructor */
	public FacelookActivity(FacelookUser facelookUser, FacelookPhoto facelookPhoto, Timestamp faTime, Integer faType, Integer fcId, Integer fmId) {
		this.facelookUser = facelookUser;
		this.facelookPhoto = facelookPhoto;
		this.faTime = faTime;
		this.faType = faType;
		this.fcId = fcId;
		this.fmId = fmId;
	}

	// Property accessors

	public Integer getFaId() {
		return this.faId;
	}

	public void setFaId(Integer faId) {
		this.faId = faId;
	}

	public FacelookUser getFacelookUser() {
		return this.facelookUser;
	}

	public void setFacelookUser(FacelookUser facelookUser) {
		this.facelookUser = facelookUser;
	}

	public FacelookPhoto getFacelookPhoto() {
		return this.facelookPhoto;
	}

	public void setFacelookPhoto(FacelookPhoto facelookPhoto) {
		this.facelookPhoto = facelookPhoto;
	}

	public Timestamp getFaTime() {
		return this.faTime;
	}

	public void setFaTime(Timestamp faTime) {
		this.faTime = faTime;
	}

	public Integer getFaType() {
		return this.faType;
	}

	public void setFaType(Integer faType) {
		this.faType = faType;
	}

	public Integer getFcId() {
		return this.fcId;
	}

	public void setFcId(Integer fcId) {
		this.fcId = fcId;
	}

	public Integer getFmId() {
		return this.fmId;
	}

	public void setFmId(Integer fmId) {
		this.fmId = fmId;
	}

}