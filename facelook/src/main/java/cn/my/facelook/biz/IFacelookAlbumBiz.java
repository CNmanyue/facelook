package cn.my.facelook.biz;

import java.util.List;

import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookAlbumBiz {

	/**
	 * 根据用户查找相册
	 * @param limit 该用户访问这个相册的权限
	 * @param user
	 * @return
	 */
	public List<FacelookAlbum> findByUser(String userId, Integer limit);
	/**
	 * 新建相册
	 * @param album
	 * @return
	 */
	public Long saveAlbum(FacelookAlbum album);
	/**
	 * 根据id查找某相册-
	 * @param albumId
	 * @return
	 */
	public FacelookAlbum findById(Long albumId);
}
