package cn.my.facelook.biz;

import java.util.List;

import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookAlbumBiz {

	/**
	 * �����û��������
	 * @param limit ���û������������Ȩ��
	 * @param user
	 * @return
	 */
	public List<FacelookAlbum> findByUser(String userId, Integer limit);
	/**
	 * �½����
	 * @param album
	 * @return
	 */
	public Long saveAlbum(FacelookAlbum album);
	/**
	 * ����id����ĳ���-
	 * @param albumId
	 * @return
	 */
	public FacelookAlbum findById(Long albumId);
}
