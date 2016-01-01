package cn.my.facelook.biz.impl;

import cn.my.facelook.biz.IFacelookCommentBiz;
import cn.my.facelook.dao.IFacelookCommentDao;
import cn.my.facelook.entity.FacelookComment;

public class FacelookCommentBizImpl implements IFacelookCommentBiz {

	private IFacelookCommentDao fcDao;
	public void setFcDao(IFacelookCommentDao fcDao) {
		this.fcDao = fcDao;
	}
	
	@Override
	public Long save(FacelookComment comment) {
		return fcDao.save(comment);
	}

	@Override
	public FacelookComment getById(Long id) {
		return fcDao.getById(id);
	}
}
