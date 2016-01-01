package cn.my.facelook.biz;

import cn.my.facelook.entity.FacelookPhoto;

public interface IFacelookPhotoBiz {

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
	public FacelookPhoto getNextPhoto(Long albumId,Integer orderNo);
	/**
	 * 获得上一张照片
	 * @param id
	 * @return
	 */
	public FacelookPhoto getPreviousPhoto(Long albumId,Integer orderNo);
	/**
	 * 临时增加的删除的照片的业务
	 * @param ids
	 */
	public void deleteById(Integer[] ids);
}
