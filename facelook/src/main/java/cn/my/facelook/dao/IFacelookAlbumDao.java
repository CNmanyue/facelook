package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookAlbumDao {

	/**
	 * �����û� �������
	 * @param userId
	 * @param limit ���û������������Ȩ��
	 * @return
	 */
	public List<FacelookAlbum> findByUserId(String userId, Integer limit);
	
	/**
	 * �½����
	 * @param album
	 * @return
	 */
	public Long saveAlbum(FacelookAlbum album);

	/**
	 * ����id�������
	 * @param albumId
	 * @return
	 */
	public FacelookAlbum findById(Long albumId);
}
