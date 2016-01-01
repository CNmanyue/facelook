package cn.my.facelook.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FacelookPhoto entity. @author MyEclipse Persistence Tools
 */

public class FacelookPhoto implements java.io.Serializable {

	// Fields

	private Integer fpPhotoId;
	private FacelookAlbum facelookAlbum;
	private Date fpCreateTime;
	private String fpName;
	private String fpContentType;
	private byte[] fpContent;
	private byte[] fpThumbnail;
	private Integer fpOrder;
	private Set facelookMarks = new HashSet(0);
	private Set facelookActivities = new HashSet(0);
	private Set facelookComments = new HashSet(0);

	// Constructors

	/** default constructor */
	public FacelookPhoto() {
	}

	/** full constructor */
	public FacelookPhoto(FacelookAlbum facelookAlbum, Date fpCreateTime, String fpName, String fpContentType, byte[] fpContent, byte[] fpThumbnail, Integer fpOrder, Set facelookMarks,
			Set facelookActivities, Set facelookComments) {
		this.facelookAlbum = facelookAlbum;
		this.fpCreateTime = fpCreateTime;
		this.fpName = fpName;
		this.fpContentType = fpContentType;
		this.fpContent = fpContent;
		this.fpThumbnail = fpThumbnail;
		this.fpOrder = fpOrder;
		this.facelookMarks = facelookMarks;
		this.facelookActivities = facelookActivities;
		this.facelookComments = facelookComments;
	}

	// Property accessors

	public Integer getFpPhotoId() {
		return this.fpPhotoId;
	}

	public void setFpPhotoId(Integer fpPhotoId) {
		this.fpPhotoId = fpPhotoId;
	}

	public FacelookAlbum getFacelookAlbum() {
		return this.facelookAlbum;
	}

	public void setFacelookAlbum(FacelookAlbum facelookAlbum) {
		this.facelookAlbum = facelookAlbum;
	}

	public Date getFpCreateTime() {
		return this.fpCreateTime;
	}

	public void setFpCreateTime(Date fpCreateTime) {
		this.fpCreateTime = fpCreateTime;
	}

	public String getFpName() {
		return this.fpName;
	}

	public void setFpName(String fpName) {
		this.fpName = fpName;
	}

	public String getFpContentType() {
		return this.fpContentType;
	}

	public void setFpContentType(String fpContentType) {
		this.fpContentType = fpContentType;
	}

	public byte[] getFpContent() {
		return this.fpContent;
	}

	public void setFpContent(byte[] fpContent) {
		this.fpContent = fpContent;
	}

	public byte[] getFpThumbnail() {
		return this.fpThumbnail;
	}

	public void setFpThumbnail(byte[] fpThumbnail) {
		this.fpThumbnail = fpThumbnail;
	}

	public Integer getFpOrder() {
		return this.fpOrder;
	}

	public void setFpOrder(Integer fpOrder) {
		this.fpOrder = fpOrder;
	}

	public Set getFacelookMarks() {
		return this.facelookMarks;
	}

	public void setFacelookMarks(Set facelookMarks) {
		this.facelookMarks = facelookMarks;
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

}