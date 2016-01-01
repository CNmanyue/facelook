package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookAlbumDao {

	/**
	 * 根据用户 查找相册
	 * @param userId
	 * @param limit 该用户访问这个相册的权限
	 * @return
	 */
	public List<FacelookAlbum> findByUserId(String userId, Integer limit);
	
	/**
	 * 新建相册
	 * @param album
	 * @return
	 */
	public Long saveAlbum(FacelookAlbum album);

	/**
	 * 根据id查找相册
	 * @param albumId
	 * @return
	 */
	public FacelookAlbum findById(Long albumId);
}
