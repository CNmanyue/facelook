package cn.my.facelook.entity;

/**
 * FacelookRelation entity. @author MyEclipse Persistence Tools
 */

public class FacelookRelation implements java.io.Serializable {

	// Fields

	private Integer frId;
	private FacelookUser facelookUserByFu2Id;
	private FacelookUser facelookUserByFu1Id;
	private Integer frRelation;

	// Constructors

	/** default constructor */
	public FacelookRelation() {
	}

	/** full constructor */
	public FacelookRelation(FacelookUser facelookUserByFu2Id, FacelookUser facelookUserByFu1Id, Integer frRelation) {
		this.facelookUserByFu2Id = facelookUserByFu2Id;
		this.facelookUserByFu1Id = facelookUserByFu1Id;
		this.frRelation = frRelation;
	}

	// Property accessors

	public Integer getFrId() {
		return this.frId;
	}

	public void setFrId(Integer frId) {
		this.frId = frId;
	}

	public FacelookUser getFacelookUserByFu2Id() {
		return this.facelookUserByFu2Id;
	}

	public void setFacelookUserByFu2Id(FacelookUser facelookUserByFu2Id) {
		this.facelookUserByFu2Id = facelookUserByFu2Id;
	}

	public FacelookUser getFacelookUserByFu1Id() {
		return this.facelookUserByFu1Id;
	}

	public void setFacelookUserByFu1Id(FacelookUser facelookUserByFu1Id) {
		this.facelookUserByFu1Id = facelookUserByFu1Id;
	}

	public Integer getFrRelation() {
		return this.frRelation;
	}

	public void setFrRelation(Integer frRelation) {
		this.frRelation = frRelation;
	}

}