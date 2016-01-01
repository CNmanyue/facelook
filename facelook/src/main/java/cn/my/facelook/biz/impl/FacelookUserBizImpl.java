package cn.my.facelook.biz.impl;

import cn.my.facelook.biz.IFacelookUserBiz;
import cn.my.facelook.dao.IFacelookUserDao;
import cn.my.facelook.entity.FacelookUser;

public class FacelookUserBizImpl implements IFacelookUserBiz {

	private IFacelookUserDao fuDao;
	
	@Override
	public FacelookUser doLogin(String id) {
		return fuDao.getById(id);
	}
	
	
	
	
	
	
	
	
	

	public IFacelookUserDao getFuDao() {
		return fuDao;
	}

	public void setFuDao(IFacelookUserDao fuDao) {
		this.fuDao = fuDao;
	}

}
