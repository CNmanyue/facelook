package cn.my.facelook.biz;

import cn.my.facelook.entity.FacelookPhoto;

public interface IFacelookPhotoBiz {

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
	public FacelookPhoto getNextPhoto(Long albumId,Integer orderNo);
	/**
	 * �����һ����Ƭ
	 * @param id
	 * @return
	 */
	public FacelookPhoto getPreviousPhoto(Long albumId,Integer orderNo);
	/**
	 * ��ʱ���ӵ�ɾ������Ƭ��ҵ��
	 * @param ids
	 */
	public void deleteById(Integer[] ids);
}
