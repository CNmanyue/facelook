package cn.my.facelook.entity;

/**
 * FacelookMark entity. @author MyEclipse Persistence Tools
 */

public class FacelookMark implements java.io.Serializable {

	// Fields

	private Integer fmId;
	private FacelookPhoto facelookPhoto;
	private String fmMarkName;
	private Integer fmLeftL;
	private Integer fmLeftT;
	private Integer fmRightL;
	private Integer fmRightT;
	private Integer fmOrder;

	// Constructors

	/** default constructor */
	public FacelookMark() {
	}

	/** full constructor */
	public FacelookMark(FacelookPhoto facelookPhoto, String fmMarkName, Integer fmLeftL, Integer fmLeftT, Integer fmRightL, Integer fmRightT, Integer fmOrder) {
		this.facelookPhoto = facelookPhoto;
		this.fmMarkName = fmMarkName;
		this.fmLeftL = fmLeftL;
		this.fmLeftT = fmLeftT;
		this.fmRightL = fmRightL;
		this.fmRightT = fmRightT;
		this.fmOrder = fmOrder;
	}

	// Property accessors

	public Integer getFmId() {
		return this.fmId;
	}

	public void setFmId(Integer fmId) {
		this.fmId = fmId;
	}

	public FacelookPhoto getFacelookPhoto() {
		return this.facelookPhoto;
	}

	public void setFacelookPhoto(FacelookPhoto facelookPhoto) {
		this.facelookPhoto = facelookPhoto;
	}

	public String getFmMarkName() {
		return this.fmMarkName;
	}

	public void setFmMarkName(String fmMarkName) {
		this.fmMarkName = fmMarkName;
	}

	public Integer getFmLeftL() {
		return this.fmLeftL;
	}

	public void setFmLeftL(Integer fmLeftL) {
		this.fmLeftL = fmLeftL;
	}

	public Integer getFmLeftT() {
		return this.fmLeftT;
	}

	public void setFmLeftT(Integer fmLeftT) {
		this.fmLeftT = fmLeftT;
	}

	public Integer getFmRightL() {
		return this.fmRightL;
	}

	public void setFmRightL(Integer fmRightL) {
		this.fmRightL = fmRightL;
	}

	public Integer getFmRightT() {
		return this.fmRightT;
	}

	public void setFmRightT(Integer fmRightT) {
		this.fmRightT = fmRightT;
	}

	public Integer getFmOrder() {
		return this.fmOrder;
	}

	public void setFmOrder(Integer fmOrder) {
		this.fmOrder = fmOrder;
	}

}