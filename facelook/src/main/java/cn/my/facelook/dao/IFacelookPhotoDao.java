package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookPhoto;

public interface IFacelookPhotoDao {

	/**
	 * 上传图片
	 * @param fp
	 * @return
	 */
	public Integer savePhoto(FacelookPhoto fp);
	/**
	 * 根据id获得照片对象
	 * @return
	 */
	public FacelookPhoto getByfpId(Integer fpId);
	/**
	 * 获得下一张照片
	 * @param id
	 * @return
	 */
	public List<FacelookPhoto> getNextPhoto(Long albumId,Integer orderNo);
	/**
	 * 获得上一张照片
	 * @param id
	 * @return
	 */
	public List<FacelookPhoto> getPreviousPhoto(Long albumId,Integer orderNo);
	/**
	 * _临时增加的删除照片的方法
	 * @param id
	 */
	public void deleteById(Integer id);
}
