package cn.my.facelook.biz.impl;

import java.util.List;

import cn.my.facelook.biz.IFacelookAlbumBiz;
import cn.my.facelook.dao.IFacelookAlbumDao;
import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookUser;

public class FacelookAlbumBizImpl implements IFacelookAlbumBiz {

	private IFacelookAlbumDao faDao;
	
	@Override
	public List<FacelookAlbum> findByUser(String userId,Integer limit) {
		return faDao.findByUserId(userId,limit);
	}

	@Override
	public Long saveAlbum(FacelookAlbum album) {
		return faDao.saveAlbum(album);
	}
	@Override
	public FacelookAlbum findById(Long albumId) {
		return faDao.findById(albumId);
	}

	public void setFaDao(IFacelookAlbumDao faDao) {
		this.faDao = faDao;
	}


}
