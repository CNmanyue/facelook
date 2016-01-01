package cn.my.facelook.biz.impl;

import java.util.List;

import cn.my.facelook.biz.IFacelookActivityBiz;
import cn.my.facelook.dao.IFacelookActivityDao;
import cn.my.facelook.dao.IFacelookUserDao;
import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookUser;

public class FacelookActivityBizImpl implements IFacelookActivityBiz {

	private IFacelookActivityDao facDao;
	private IFacelookUserDao fuDao;
	public void setFacDao(IFacelookActivityDao facDao) {
		this.facDao = facDao;
	}
	
	
	public void setFuDao(IFacelookUserDao fuDao) {
		this.fuDao = fuDao;
	}


	@Override
	public List<FacelookActivity> getList(FacelookUser user) {
		return facDao.getList(user);
	}


	@Override
	public Long save(FacelookActivity activity) {
		return facDao.save(activity);
	}

}
