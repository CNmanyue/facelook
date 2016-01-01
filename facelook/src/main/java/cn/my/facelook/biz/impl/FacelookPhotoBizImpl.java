package cn.my.facelook.biz.impl;

import java.util.List;

import cn.my.facelook.biz.IFacelookPhotoBiz;
import cn.my.facelook.dao.IFacelookPhotoDao;
import cn.my.facelook.entity.FacelookPhoto;

public class FacelookPhotoBizImpl implements IFacelookPhotoBiz {

	private IFacelookPhotoDao fpDao;
	public void setFpDao(IFacelookPhotoDao fpDao) {
		this.fpDao = fpDao;
	}
	@Override
	public Integer savePhoto(cn.my.facelook.entity.FacelookPhoto fp) {
		return fpDao.savePhoto(fp);
	}

	@Override
	public cn.my.facelook.entity.FacelookPhoto getByfpId(Integer fpId) {
		return fpDao.getByfpId(fpId);
	}

	@Override
	public FacelookPhoto getNextPhoto(Long albumId,Integer orderNo) {
		List<FacelookPhoto> list = fpDao.getNextPhoto(albumId,orderNo);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public FacelookPhoto getPreviousPhoto(Long albumId,Integer orderNo) {
		List<FacelookPhoto> list = fpDao.getPreviousPhoto(albumId, orderNo);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public void deleteById(Integer[] ids) {
		for (Integer id : ids) {
			fpDao.deleteById(id);			
		}
	}

}
