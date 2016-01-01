package cn.my.facelook.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * FacelookAlbum entity. @author MyEclipse Persistence Tools
 */

public class FacelookAlbum implements java.io.Serializable {

	// Fields

	private Integer faAlbumId;
	private FacelookUser facelookUser;
	private String faAlbumName;
	private Integer faLimit;
	private Set facelookPhotos = new HashSet(0);

	// Constructors

	/** default constructor */
	public FacelookAlbum() {
	}

	/** full constructor */
	public FacelookAlbum(FacelookUser facelookUser, String faAlbumName, Integer faLimit, Set facelookPhotos) {
		this.facelookUser = facelookUser;
		this.faAlbumName = faAlbumName;
		this.faLimit = faLimit;
		this.facelookPhotos = facelookPhotos;
	}

	// Property accessors

	public Integer getFaAlbumId() {
		return this.faAlbumId;
	}

	public void setFaAlbumId(Integer faAlbumId) {
		this.faAlbumId = faAlbumId;
	}

	public FacelookUser getFacelookUser() {
		return this.facelookUser;
	}

	public void setFacelookUser(FacelookUser facelookUser) {
		this.facelookUser = facelookUser;
	}

	public String getFaAlbumName() {
		return this.faAlbumName;
	}

	public void setFaAlbumName(String faAlbumName) {
		this.faAlbumName = faAlbumName;
	}

	public Integer getFaLimit() {
		return this.faLimit;
	}

	public void setFaLimit(Integer faLimit) {
		this.faLimit = faLimit;
	}

	public Set getFacelookPhotos() {
		return this.facelookPhotos;
	}

	public void setFacelookPhotos(Set facelookPhotos) {
		this.facelookPhotos = facelookPhotos;
	}

}