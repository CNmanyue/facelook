package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookPhoto;

public interface IFacelookPhotoDao {

	/**
	 * �ϴ�ͼƬ
	 * @param fp
	 * @return
	 */
	public Integer savePhoto(FacelookPhoto fp);
	/**
	 * ����id�����Ƭ����
	 * @return
	 */
	public FacelookPhoto getByfpId(Integer fpId);
	/**
	 * �����һ����Ƭ
	 * @param id
	 * @return
	 */
	public List<FacelookPhoto> getNextPhoto(Long albumId,Integer orderNo);
	/**
	 * �����һ����Ƭ
	 * @param id
	 * @return
	 */
	public List<FacelookPhoto> getPreviousPhoto(Long albumId,Integer orderNo);
	/**
	 * _��ʱ���ӵ�ɾ����Ƭ�ķ���
	 * @param id
	 */
	public void deleteById(Integer id);
}
