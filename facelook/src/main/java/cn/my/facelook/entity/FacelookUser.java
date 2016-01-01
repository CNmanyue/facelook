package cn.my.facelook.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * FacelookUser entity. @author MyEclipse Persistence Tools
 */

public class FacelookUser implements java.io.Serializable {

	// Fields

	private String fuUserId;
	private String fuUserName;
	private String fuPassword;
	private String fuEmail;
	private Integer fuStatus;
	private Set facelookActivities = new HashSet(0);
	private Set facelookComments = new HashSet(0);
	private Set facelookAlbums = new HashSet(0);
	private Set facelookRelationsForFu1Id = new HashSet(0);
	private Set facelookRelationsForFu2Id = new HashSet(0);

	// Constructors

	/** default constructor */
	public FacelookUser() {
	}

	/** full constructor */
	public FacelookUser(String fuUserName, String fuPassword, String fuEmail, Integer fuStatus, Set facelookActivities, Set facelookComments, Set facelookAlbums, Set facelookRelationsForFu1Id,
			Set facelookRelationsForFu2Id) {
		this.fuUserName = fuUserName;
		this.fuPassword = fuPassword;
		this.fuEmail = fuEmail;
		this.fuStatus = fuStatus;
		this.facelookActivities = facelookActivities;
		this.facelookComments = facelookComments;
		this.facelookAlbums = facelookAlbums;
		this.facelookRelationsForFu1Id = facelookRelationsForFu1Id;
		this.facelookRelationsForFu2Id = facelookRelationsForFu2Id;
	}

	// Property accessors

	public String getFuUserId() {
		return this.fuUserId;
	}

	public void setFuUserId(String fuUserId) {
		this.fuUserId = fuUserId;
	}

	public String getFuUserName() {
		return this.fuUserName;
	}

	public void setFuUserName(String fuUserName) {
		this.fuUserName = fuUserName;
	}

	public String getFuPassword() {
		return this.fuPassword;
	}

	public void setFuPassword(String fuPassword) {
		this.fuPassword = fuPassword;
	}

	public String getFuEmail() {
		return this.fuEmail;
	}

	public void setFuEmail(String fuEmail) {
		this.fuEmail = fuEmail;
	}

	public Integer getFuStatus() {
		return this.fuStatus;
	}

	public void setFuStatus(Integer fuStatus) {
		this.fuStatus = fuStatus;
	}

	public Set getFacelookActivities() {
		return this.facelookActivities;
	}

	public void setFacelookActivities(Set facelookActivities) {
		this.facelookActivities = facelookActivities;
	}

	public Set getFacelookComments() {
		return this.facelookComments;
	}

	public void setFacelookComments(Set facelookComments) {
		this.facelookComments = facelookComments;
	}

	public Set getFacelookAlbums() {
		return this.facelookAlbums;
	}

	public void setFacelookAlbums(Set facelookAlbums) {
		this.facelookAlbums = facelookAlbums;
	}

	public Set getFacelookRelationsForFu1Id() {
		return this.facelookRelationsForFu1Id;
	}

	public void setFacelookRelationsForFu1Id(Set facelookRelationsForFu1Id) {
		this.facelookRelationsForFu1Id = facelookRelationsForFu1Id;
	}

	public Set getFacelookRelationsForFu2Id() {
		return this.facelookRelationsForFu2Id;
	}

	public void setFacelookRelationsForFu2Id(Set facelookRelationsForFu2Id) {
		this.facelookRelationsForFu2Id = facelookRelationsForFu2Id;
	}

}