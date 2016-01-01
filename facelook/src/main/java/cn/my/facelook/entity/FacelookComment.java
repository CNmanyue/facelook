package cn.my.facelook.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FacelookComment entity. @author MyEclipse Persistence Tools
 */

public class FacelookComment implements java.io.Serializable {

	// Fields

	private Integer fcId;
	private FacelookUser facelookUser;
	private FacelookComment facelookComment;
	private FacelookPhoto facelookPhoto;
	private Date fcCreateTime;
	private String fcComment;
	private Integer fcOrder;
	private Set facelookComments = new HashSet(0);

	// Constructors

	/** default constructor */
	public FacelookComment() {
	}

	/** full constructor */
	public FacelookComment(FacelookUser facelookUser, FacelookComment facelookComment, FacelookPhoto facelookPhoto, Date fcCreateTime, String fcComment, Integer fcOrder, Set facelookComments) {
		this.facelookUser = facelookUser;
		this.facelookComment = facelookComment;
		this.facelookPhoto = facelookPhoto;
		this.fcCreateTime = fcCreateTime;
		this.fcComment = fcComment;
		this.fcOrder = fcOrder;
		this.facelookComments = facelookComments;
	}

	// Property accessors

	public Integer getFcId() {
		return this.fcId;
	}

	public void setFcId(Integer fcId) {
		this.fcId = fcId;
	}

	public FacelookUser getFacelookUser() {
		return this.facelookUser;
	}

	public void setFacelookUser(FacelookUser facelookUser) {
		this.facelookUser = facelookUser;
	}

	public FacelookComment getFacelookComment() {
		return this.facelookComment;
	}

	public void setFacelookComment(FacelookComment facelookComment) {
		this.facelookComment = facelookComment;
	}

	public FacelookPhoto getFacelookPhoto() {
		return this.facelookPhoto;
	}

	public void setFacelookPhoto(FacelookPhoto facelookPhoto) {
		this.facelookPhoto = facelookPhoto;
	}

	public Date getFcCreateTime() {
		return this.fcCreateTime;
	}

	public void setFcCreateTime(Date fcCreateTime) {
		this.fcCreateTime = fcCreateTime;
	}

	public String getFcComment() {
		return this.fcComment;
	}

	public void setFcComment(String fcComment) {
		this.fcComment = fcComment;
	}

	public Integer getFcOrder() {
		return this.fcOrder;
	}

	public void setFcOrder(Integer fcOrder) {
		this.fcOrder = fcOrder;
	}

	public Set getFacelookComments() {
		return this.facelookComments;
	}

	public void setFacelookComments(Set facelookComments) {
		this.facelookComments = facelookComments;
	}

}